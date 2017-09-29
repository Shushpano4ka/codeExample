package com.vadymusyk.code_example.algorithms.rating.impl;

import com.vadymusyk.code_example.algorithms.rating.WilsonScoreIntervalAlgorithm;
import com.vadymusyk.code_example.entity.company.rating.DepartmentRating;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WilsonScoreIntervalAlgorithmImpl implements WilsonScoreIntervalAlgorithm {


    @Override
    public Double countRating(List<DepartmentRating> ratingList) {

        FiveStarRating fiveStarRating = new FiveStarRating();
        ratingList.forEach(userRating -> {
            switch (userRating.getRating()) {
                case 1:
                    fiveStarRating.incrementAmount1();
                    break;
                case 2:
                    fiveStarRating.incrementAmount2();
                    break;
                case 3:
                    fiveStarRating.incrementAmount3();
                    break;
                case 4:
                    fiveStarRating.incrementAmount4();
                    break;
                case 5:
                    fiveStarRating.incrementAmount5();
                    break;
            }
        });
        fiveStarRating.countPositive();
        fiveStarRating.countNegative();
        System.out.println(fiveStarRating.toString());
        return ratingByWilsonScoreConfidence(fiveStarRating.getPositive(), fiveStarRating.getNegative());
    }

    private double ratingByWilsonScoreConfidence(double positive, double negative) {
        double sum = positive + negative;
        double multiplicationResult = positive * negative;
        double result = (((positive + 1.9208) / sum - 1.96 * Math.sqrt(Math.abs((multiplicationResult / sum) + 0.9604)) / sum) / (1 + 3.8416 / sum));
        return result;
    }

    @Override
    public Double countRating(List<UserRating> userRatings, boolean isTest) {
        List<DepartmentRating> collect = userRatings.stream().map(userRating -> DepartmentRating.builder().rating(userRating.getRating())
                .build()).collect(Collectors.toList());
        return countRating(collect);
    }

    @Data
    private class FiveStarRating {
        private int amount1 = 0;
        private int amount2 = 0;
        private int amount3 = 0;
        private int amount4 = 0;
        private int amount5 = 0;


        private double positive = 0;
        private double negative = 0;

        public void incrementAmount1() {
            this.amount1++;
        }

        public void incrementAmount2() {
            this.amount2++;
        }

        public void incrementAmount3() {
            this.amount3++;
        }

        public void incrementAmount4() {
            this.amount4++;
        }

        public void incrementAmount5() {
            this.amount5++;
        }


        public void countPositive() {
            this.positive = this.amount2 + 0.25 * this.amount3 * 0.5 + amount4 * 0.75 + amount5;
        }

        public void countNegative() {

            this.negative = this.amount1 + 0.75 * this.amount2 + 0.5 * this.amount3 * 0.25 * amount4;
        }


        @Override
        public String toString() {
            return "FiveStarRating{" +
                    "amount1=" + amount1 +
                    ", amount2=" + amount2 +
                    ", amount3=" + amount3 +
                    ", amount4=" + amount4 +
                    ", amount5=" + amount5 +
                    ", positive=" + positive +
                    ", negative=" + negative +
                    '}';
        }
    }

}

