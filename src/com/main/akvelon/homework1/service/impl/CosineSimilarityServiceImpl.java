package com.main.akvelon.homework1.service.impl;

import com.main.akvelon.homework1.service.CosineSimilarityService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CosineSimilarityServiceImpl implements CosineSimilarityService {

    @Override
    public Double cosineSimilarity(String firstString, String secondString) {
        Map<String, Integer> leftVector = toVector(firstString);
        Map<String, Integer> rightVector = toVector(secondString);
        Set<String> intersection = getIntersection(leftVector, rightVector);

        double dotProduct = dot(leftVector, rightVector, intersection);

        double d1 = 0.0d;
        for (Integer value : leftVector.values()) {
            d1 += Math.pow(value, 2);
        }

        double d2 = 0.0d;
        for (Integer value : rightVector.values()) {
            d2 += Math.pow(value, 2);
        }

        if (d1 <= 0.0 || d2 <= 0.0) {
            return 0.0;
        }

        return dotProduct / (Math.sqrt(d1) * Math.sqrt(d2));
    }

    private double dot(Map<String, Integer> leftVector, Map<String, Integer> rightVector,
                       Set<String> intersection) {
        double dotProduct = 0;
        for (String key : intersection) {
            dotProduct += leftVector.get(key) * rightVector.get(key);
        }
        return dotProduct;
    }

    private Set<String> getIntersection(Map<String, Integer> leftVector,
                                        Map<String, Integer> rightVector) {
        Set<String> intersection = new HashSet<>(leftVector.keySet());
        intersection.retainAll(rightVector.keySet());
        return intersection;
    }

    private Map<String, Integer> toVector(String value) {
        Map<String, Integer> vector = new HashMap<>();

        for (String word : value.split(" ")) {
            String trimmedWord = word.trim();
            if (!vector.containsKey(trimmedWord)) {
                vector.put(trimmedWord, 1);
            } else {
                int frequency = vector.get(trimmedWord);
                vector.put(trimmedWord, ++frequency);
            }
        }
        return vector;
    }

}
