package com.formento.algorithmexercises.pointinrectangle.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.Point;
import com.formento.algorithmexercises.pointinrectangle.junit.template.PointTemplate;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Collection;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.BeforeClass;
import org.junit.Test;

public class PointTest {

    @BeforeClass
    public static void initClass() {
        FixtureFactoryLoader.loadTemplates("com.formento.algorithmexercises.pointinrectangle.junit.template");
    }

    @Test
    public void shouldCreatePoint() {
        // given
        final Point point = Fixture.from(Point.class).gimme(PointTemplate.P_1_2);

        // then
        assertNotNull(point);
        assertEquals(Integer.valueOf(1), point.getX());
        assertEquals(Integer.valueOf(2), point.getY());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Point.class).verify();
    }

    @Test
    public void shouldBeValidComparatorByNatural() {
        // given
        final Point point_1_2 = Fixture.from(Point.class).gimme(PointTemplate.P_1_2);
        final Point point_2_0 = Fixture.from(Point.class).gimme(PointTemplate.P_2_0);
        final Point point_2_3 = Fixture.from(Point.class).gimme(PointTemplate.P_2_3);
        final Point point_2_5 = Fixture.from(Point.class).gimme(PointTemplate.P_2_5);
        final Point point_3_0 = Fixture.from(Point.class).gimme(PointTemplate.P_3_0);

        // when
        final Collection<Point> points = ImmutableSortedSet.<Point>naturalOrder().add(
            point_2_3,
            point_1_2,
            point_2_5,
            point_3_0,
            point_2_0
        ).build();

        // then
        assertThat(points, contains(
            allOf(hasProperty("x", is(1)), hasProperty("y", is(2))),
            allOf(hasProperty("x", is(2)), hasProperty("y", is(0))),
            allOf(hasProperty("x", is(2)), hasProperty("y", is(3))),
            allOf(hasProperty("x", is(2)), hasProperty("y", is(5))),
            allOf(hasProperty("x", is(3)), hasProperty("y", is(0)))
        ));
    }

}
