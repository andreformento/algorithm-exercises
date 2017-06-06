package com.formento.algorithmexercises.pointinrectangle.junit.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.formento.algorithmexercises.pointinrectangle.Rectangle;
import com.formento.algorithmexercises.pointinrectangle.Region;

public class RegionTemplate implements TemplateLoader {

    public final static String VALID = "Valid";

    @Override
    public void load() {
        Fixture.of(Region.class)
            .addTemplate(VALID, new Rule() {{
                add("rectangles", has(6).of(Rectangle.class,
                    RectangleTemplate.A,
                    RectangleTemplate.B,
                    RectangleTemplate.C,
                    RectangleTemplate.D,
                    RectangleTemplate.E,
                    RectangleTemplate.F
                ));
            }});
    }

}
