package com.formento.algorithmexercises.pointinrectangle;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.template.PointTemplate;
import com.formento.algorithmexercises.pointinrectangle.template.RectangleTemplate;
import com.formento.algorithmexercises.pointinrectangle.template.RegionTemplate;
import java.util.Collection;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegionTest {

    @BeforeClass
    public static void initClass() {
        FixtureFactoryLoader.loadTemplates("com.formento.algorithmexercises.pointinrectangle.template");
    }

    @Test
    public void shouldCreateRegion() {
        // given
        Region region = Fixture.from(Region.class).gimme(RegionTemplate.VALID);

        // then
        assertNotNull(region);
        assertNotNull(region.getRectangles());
        assertEquals(6, region.getRectangles().size());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Region.class).verify();
    }

    @Test
    public void shouldAddInXYPointOrder() {
        // given
        final Region region = new Region.Builder().addRectangle(
            Fixture.from(Rectangle.class).gimme(RectangleTemplate.F),
            Fixture.from(Rectangle.class).gimme(RectangleTemplate.B),
            Fixture.from(Rectangle.class).gimme(RectangleTemplate.E),
            Fixture.from(Rectangle.class).gimme(RectangleTemplate.D),
            Fixture.from(Rectangle.class).gimme(RectangleTemplate.A),
            Fixture.from(Rectangle.class).gimme(RectangleTemplate.C)
        ).build();

        // when
        final Collection<Rectangle> result = region.getRectangles();

        // then
        assertThat(result, contains(
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_0_0))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_3)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_0_3))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_5)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_1_2))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_4_4)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_0))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_4_3)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_2_3))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_6_5)))),
            allOf(hasProperty("leftBottom", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_3_0))), hasProperty("rightTop", is(Fixture.from(Point.class).<Point>gimme(PointTemplate.P_6_3))))
        ));
    }

}
