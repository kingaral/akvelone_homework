package com.main.akvelon.homework1;

import com.main.akvelon.homework1.service.CosineSimilarityService;
import com.main.akvelon.homework1.service.impl.CosineSimilarityServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CosineSimilarityService cosineSimilarityService = new CosineSimilarityServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first text: ");
        String firstText = scanner.nextLine();
        System.out.println("Please enter second text:: ");
        String secondText = scanner.nextLine();
        scanner.close();
        Double cosineSimilarity = cosineSimilarityService.cosineSimilarity(firstText, secondText);
        System.out.println(String.format("Cosine similarity for texts %s and %s is %s",
                firstText, secondText, cosineSimilarity));
    }

}
