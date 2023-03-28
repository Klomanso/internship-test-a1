package com.example.internship_test_a1.task3.service;

import com.example.internship_test_a1.task3.model.*;
import com.example.internship_test_a1.task3.model.utility.CompositePDetailsId;
import com.example.internship_test_a1.task3.model.utility.CsvLogin;
import com.example.internship_test_a1.task3.model.utility.CsvPosting;
import com.example.internship_test_a1.task3.repository.*;
import com.example.internship_test_a1.task3.utility.parser.impl.CsvLoginsParser;
import com.example.internship_test_a1.task3.utility.parser.impl.CsvPostingsParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DataLoadingService {

        private final CsvLoginsParser csvLoginsParser;
        private final CsvPostingsParser csvPostingsParser;

        ApplicationRepository applicationRepository;
        CurrencyRepository currencyRepository;
        DepartmentRepository departmentRepository;
        JobTitleRepository jobTitleRepository;
        LoginRepository loginRepository;
        PostingRepository postingRepository;
        PostingDetailsRepository postingDetailsRepository;
        UnitRepository unitRepository;
        ProductRepository productRepository;

        public void LoadData() throws FileNotFoundException {

                Set<Application> applications = new HashSet<>();
                Set<Currency> currencies = new HashSet<>();
                Set<Department> departments = new HashSet<>();
                Set<JobTitle> titles = new HashSet<>();
                Set<Product> products = new HashSet<>();
                Set<Unit> units = new HashSet<>();
                List<Login> loginList = new ArrayList<>();
                List<Posting> postingList = new ArrayList<>();
                List<PostingDetails> postingDetails = new ArrayList<>();

                List<CsvLogin> logins = csvLoginsParser.parse();
                List<CsvPosting> postings = csvPostingsParser.parse();


                loadLoginsReferences(logins, applications, departments, titles);
                loadPostingsReferences(postings, currencies, products, units);
                loadLogins(logins, loginList);
                loadPostings(postings, postingList);
                loadPostingDetails(postings, postingDetails);
        }

        private void loadLoginsReferences(List<CsvLogin> logins,
                                          Set<Application> applications,
                                          Set<Department> departments,
                                          Set<JobTitle> titles) {
                for (CsvLogin login : logins) {
                        applications.add(new Application(login.getApplication()));
                        departments.add(new Department(login.getDepartment()));
                        titles.add(new JobTitle(login.getJobTitle()));
                }

                applicationRepository.saveAll(applications);
                departmentRepository.saveAll(departments);
                jobTitleRepository.saveAll(titles);
        }

        private void loadPostingsReferences(List<CsvPosting> postings,
                                            Set<Currency> currencies,
                                            Set<Product> products,
                                            Set<Unit> units) {
                for (CsvPosting posting : postings) {
                        currencies.add(new Currency(posting.getCurrency()));
                        products.add(new Product(posting.getMaterialDescription()));
                        units.add(new Unit(posting.getUnit()));
                }

                currencyRepository.saveAll(currencies);
                productRepository.saveAll(products);
                unitRepository.saveAll(units);
        }

        private void loadLogins(List<CsvLogin> logins, List<Login> loginList) {
                for (CsvLogin login : logins) {

                        loginList.add(Login.builder()
                                .accountName(login.getAppAccountName())
                                .isActive(login.getIsActive())
                                .application(applicationRepository.findByName(login.getApplication()))
                                .department(departmentRepository.findByName(login.getDepartment()))
                                .title(jobTitleRepository.findByName(login.getJobTitle()))
                                .build());
                }

                loginRepository.saveAll(loginList);
        }

        private void loadPostings(List<CsvPosting> postings, List<Posting> postingList) {
                for (CsvPosting posting : postings) {

                        Boolean isAuthorizedPosting =
                                loginRepository.existsByAccountName(posting.getUserName())
                                        && (loginRepository.findByAccountName(posting.getUserName()).getIsActive());


                        postingList.add(Posting.builder()
                                .matDoc(posting.getMatDoc())
                                .docDate(posting.getDocDate())
                                .postingDate(posting.getPostingDate())
                                .currency(currencyRepository.findByName(posting.getCurrency()))
                                .login(loginRepository.findByAccountName(posting.getUserName()))
                                .authorized(isAuthorizedPosting)
                                .build());
                }

                postingRepository.saveAll(postingList);
        }

        private void loadPostingDetails(List<CsvPosting> postings, List<PostingDetails> postingDetails) {
                for (CsvPosting posting : postings) {

                        postingDetails.add(PostingDetails.builder()
                                .amountLC(posting.getAmountLC())
                                .quantity(posting.getQuantity())
                                .product(productRepository.findByDescription(posting.getMaterialDescription()))
                                .unit(unitRepository.findByName(posting.getUnit()))
                                .compositeId(CompositePDetailsId.builder()
                                        .item(posting.getItem())
                                        .posting(postingRepository.findByMatDoc(posting.getMatDoc())).build())
                                .build());
                }

                postingDetailsRepository.saveAll(postingDetails);
        }
}
