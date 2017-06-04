package com.formento.algorithmexercises.pointinrectangle.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.formento.algorithmexercises.pointinrectangle.Rectangle;

public class RegionTemplate implements TemplateLoader {

    public final static String VALID = "Valid";

    @Override
    public void load() {
        Fixture.of(Rectangle.class)
            .addTemplate(VALID, new Rule() {{
                add("rectangles", has(3).of(Rectangle.class,
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
