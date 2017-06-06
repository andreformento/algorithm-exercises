package com.formento.algorithmexercises.pointinrectangle.junit.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.formento.algorithmexercises.pointinrectangle.Point;
import com.formento.algorithmexercises.pointinrectangle.Rectangle;

public class RectangleTemplate implements TemplateLoader {

    public final static String A = "A";
    public final static String B = "B";
    public final static String C = "C";
    public final static String D = "D";
    public final static String E = "E";
    public final static String F = "F";

    @Override
    public void load() {
        Fixture.of(Rectangle.class)
            .addTemplate(A, new Rule() {{
                add("leftBottom", one(Point.class, PointTemplate.P_0_0));
                add("rightTop", one(Point.class, PointTemplate.P_2_3));
            }})
            .addTemplate(B, new Rule() {{
                add("leftBottom", one(Point.class, PointTemplate.P_0_3));
                add("rightTop", one(Point.class, PointTemplate.P_2_5));
            }})
            .addTemplate(C, new Rule() {{
                add("leftBottom", one(Point.class, PointTemplate.P_1_2));
                add("rightTop", one(Point.class, PointTemplate.P_4_4));
            }})
            .addTemplate(D, new Rule() {{
                add("leftBottom", one(Point.class, PointTemplate.P_2_0));
                add("rightTop", one(Point.class, PointTemplate.P_4_3));
            }})
            .addTemplate(E, new Rule() {{
                add("leftBottom", one(Point.class, PointTemplate.P_2_3));
                add("rightTop", one(Point.class, PointTemplate.P_6_5));
            }})
            .addTemplate(F, new Rule() {{
                add("leftBottom", one(Point.class, PointTemplate.P_3_0));
                add("rightTop", one(Point.class, PointTemplate.P_6_3));
            }});
    }

}
