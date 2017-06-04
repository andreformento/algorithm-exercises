package com.formento.algorithmexercises.pointinrectangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.template.PointTemplate;
import org.junit.BeforeClass;
import org.junit.Test;

public class PointTest {

    @BeforeClass
    public static void initClass() {
        FixtureFactoryLoader.loadTemplates("com.formento.algorithmexercises.pointinrectangle.template");
    }

    @Test
    public void shouldCreatePoint() {
        // given
        Point point = Fixture.from(Point.class).gimme(PointTemplate.P_1_2);

        // then
        assertNotNull(point);
        assertEquals(Integer.valueOf(1), point.getX());
        assertEquals(Integer.valueOf(2), point.getY());
    }

}
