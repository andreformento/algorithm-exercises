package com.formento.algorithmexercises.distancecalculator;

import com.google.common.collect.ImmutableList;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class DistanceCalculator {

    public Map<Character, List<Integer>> calculateDistance(final List<Character> characters, final Integer maxDistance) {
        return characters
                .stream()
                .distinct()
                .map(character -> new AbstractMap.SimpleImmutableEntry<>(character, getDistances(characters, maxDistance, character)))
                .filter(entry -> !entry.getValue().isEmpty())
                .sorted(comparing(AbstractMap.SimpleImmutableEntry::getKey))
                .collect(
                        toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        )
                );
    }

    private List<Integer> getDistances(final List<Character> characters, final Integer maxDistance, final Character character) {
        final List<Integer> indexes = IntStream
                .range(0, characters.size())
                .filter(index -> character.equals(characters.get(index)))
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
