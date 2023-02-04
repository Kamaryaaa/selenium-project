package com.cydeo.tests.day09_review_javaFaker_driveUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){
        Faker faker = new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.address() = " + faker.address().city());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        String randomNumber = faker.numerify("###-###-####");
        String randomNumbe2r = faker.numerify("###-#78-####-###");
        System.out.println("faker.letterify(\"??? ??? ?????? ????????????????\") = " + faker.letterify("??? ??? ?????? ????????????????"));
        System.out.println("faker.bothify(\"???#???####???\") = " + faker.bothify("???#???####???"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("randomNumber = " + randomNumber);
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());
        System.out.println("faker.muhtar().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris","Muhtar"));

    }
}
