package com.formento.algorithmexercises.pointinrectangle;

import static org.junit.Assert.assertNotNull;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.template.RectangleTemplate;
import org.junit.BeforeClass;
import org.junit.Test;

public class RectangleTest {

    @BeforeClass
    public static void initClass() {
        FixtureFactoryLoader.loadTemplates("com.formento.algorithmexercises.pointinrectangle.template");
    }

    @Test
    public void shouldCreateRectangle(){
        // given
        Rectangle rectangle = Fixture.from(Rectangle.class).gimme(RectangleTemplate.A);

        // then
        assertNotNull(rectangle);
        assertNotNull(rectangle.getLeftBottom());
        assertNotNull(rectangle.getRightTop());
    }

}
