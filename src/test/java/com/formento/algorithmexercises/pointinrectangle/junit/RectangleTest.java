package com.formento.algorithmexercises.pointinrectangle.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import com.formento.algorithmexercises.pointinrectangle.junit.template.RectangleTemplate;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import com.formento.algorithmexercises.pointinrectangle.junit.template.RectangleTemplate;
import com.formento.algorithmexercises.pointinrectangle.junit.template.PointTemplate;
import com.formento.algorithmexercises.pointinrectangle.junit.template.RegionTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.Point;
import com.formento.algorithmexercises.pointinrectangle.Rectangle;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Collection;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

public class RectangleTest {

    @BeforeClass
    public static void initClass() {
        FixtureFactoryLoader.loadTemplates("com.formento.algorithmexercises.pointinrectangle.junit.template");
    }

    @Test
    public void shouldCreateRectangle() {
        // given
        final Rectangle rectangle = Fixture.from(Rectangle.class).gimme(RectangleTemplate.A);

        // then
        assertNotNull(rectangle);
        assertNotNull(rectangle.getLeftBottom());
        assertNotNull(rectangle.getRightTop());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Rectangle.class).verify();
    }

    @Test
    public void shouldBeValidComparatorByNatural() {
        // given
        final Rectangle rectangle_A = Fixture.from(Rectangle.class).gimme(RectangleTemplate.A);
        final Rectangle rectangle_B = Fixture.from(Rectangle.class).gimme(RectangleTemplate.B);
        final Rectangle rectangle_C = Fixture.from(Rectangle.class).gimme(RectangleTemplate.C);
        final Rectangle rectangle_D = Fixture.from(Rectangle.class).gimme(RectangleTemplate.D);
        final Rectangle rectangle_E = Fixture.from(Rectangle.class).gimme(RectangleTemplate.E);
        final Rectangle rectangle_F = Fixture.from(Rectangle.class).gimme(RectangleTemplate.F);

        // when
        final Collection<Rectangle> rectangles = ImmutableSortedSet.<Rectangle>naturalOrder().add(
            rectangle_C,
            rectangle_A,
            rectangle_D,
            rectangle_F,
            rectangle_E,
            rectangle_B
        ).build();

        // then
        assertThat(rectangles, Matchers.contains(
            Matchers.allOf(hasProperty("leftBottom", CoreMatchers.is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_0_0))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_3)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_0_3))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_5)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_1_2))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_4_4)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_0))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_4_3)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_3))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_6_5)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_3_0))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_6_3))))
        ));
    }

}
