package com.formento.challengeexercises.component;

import com.google.common.collect.ImmutableList;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class DistanceCalculator {

    public Map<String, List<Integer>> calculateLessDistance(final List<String> words, final Integer maxDistance) {
        return words
                .stream()
                .distinct()
                .map(word -> new AbstractMap.SimpleImmutableEntry<>(word, getDistances(words, maxDistance, word)))
                .filter(entry -> !entry.getValue().isEmpty())
                .sorted(comparing(AbstractMap.SimpleImmutableEntry::getKey))
                .collect(
                        toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        )
                );
    }

    private List<Integer> getDistances(final List<String> words, final Integer maxDistance, final String word) {
        final List<Integer> indexes = IntStream
                .range(0, words.size())
                .filter(index -> word.equals(words.get(index)))
                .boxed()
                .collect(toList());

        final ImmutableList.Builder<Integer> distances = ImmutableList.builder();
        for (int i = 1; i < indexes.size(); i++) {
            distances.add(indexes.get(i) - indexes.get(i - 1));
        }

        return distances
                .build()
                .stream()
                .filter(index -> index <= maxDistance)
                .collect(toList());
    }

}
