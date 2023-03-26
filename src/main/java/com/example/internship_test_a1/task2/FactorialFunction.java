package com.example.internship_test_a1.task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FactorialFunction {

        /*
         * lim( un = (1/n!) * (1! + 2! + 3! + ... + n!) ) = 1, при n -> +inf
         *
         * Док-во:
         *       используемые свойства:
         *               1) n! = (n - 1)! * n
         *               2) lim(f(x) + g(x)) = lim(f(x)) + lim(g(x))
         *
         *       Преобразуем выражение un:
         *               un = (1/n!) * (1! + 2! + 3! + ... + n!) =
         *
         *               = 1/n! + 2/n! + 6/n! + ... + (n-2)!/n! + (n-1)!/n! + n!/n! =
         *
         *               = 1/n! + 2/n! + 6/n! + ... + 1/((n-1)*n) + 1/n + 1;
         *
         *       Получим:
         *               un = 0 + 0 + 0 + ... + 0 + 0 + 1 = 1, при n -> +inf
         *
         * Function:
         *       Time Complexity: O(n)
         *       Space Complexity: O(1), не учитывая внутреннюю реализацию BigDecimal
         *       n - число, для которого расчитывается значение функции
         */

        public static double calculateFunValue(int n) {
                BigDecimal f = BigDecimal.ONE; // значение факториала
                BigDecimal s = BigDecimal.ONE; // значение суммы факториалов

                for (int i = 2; i <= n; i++) {
                        f = f.multiply(BigDecimal.valueOf(i));
                        s = s.add(f);
                }

                return s.divide(f,6,RoundingMode.HALF_UP).doubleValue();
        }
}
