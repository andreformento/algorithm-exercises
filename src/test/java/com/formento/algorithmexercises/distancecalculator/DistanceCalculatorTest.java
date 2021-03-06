package com.formento.algorithmexercises.distancecalculator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DistanceCalculatorTest {

    private DistanceCalculator distanceCalculator;

    @Before
    public void init() {
        this.distanceCalculator = new DistanceCalculator();
    }

    @Test
    public void shouldCalculateDistance() {
        // given
        final List<Character> characters = ImmutableList.<Character>builder()
                .add('d')
                .add('j')
                .add('b')
                .add('c')
                .add('j')
                .add('j')
                .add('b')
                .add('d')
                .add('e')
                .add('b')
                .add('e')
                .add('g')
                .add('d')
                .add('e')
                .build();


        final Integer maxDistance = 3;

        final Map<Character, List<Integer>> expected = ImmutableMap.<Character, List<Integer>>builder()
                .put('b', ImmutableList.<Integer>builder().add(3).build())
                .put('e', ImmutableList.<Integer>builder().add(2, 3).build())
                .put('j', ImmutableList.<Integer>builder().add(3, 1).build())
                .build();

        // when
        final Map<Character, List<Integer>> result = distanceCalculator.calculateDistance(characters, maxDistance);

        // then
        assertEquals(expected, result);
    }

}
