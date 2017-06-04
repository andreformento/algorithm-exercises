package com.formento.algorithmexercises.pointinrectangle.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PointTemplate implements TemplateLoader {

    public final static String P_0_0 = "(0,0)";
    public final static String P_2_3 = "(2,3)";
    public final static String P_0_3 = "(0,3)";
    public final static String P_2_5 = "(2,5)";
    public final static String P_1_2 = "(1,2)";
    public final static String P_4_4 = "(4,4)";
    public final static String P_2_0 = "(2,0)";
    public final static String P_4_3 = "(4,3)";
    public final static String P_6_5 = "(6,5)";
    public final static String P_3_0 = "(3,0)";
    public final static String P_6_3 = "(6,3)";

    @Override
    public void load() {
        Fixture.of(Point.class)
            .addTemplate(P_0_0, new Rule() {{
                add("x", 0);
                add("y", 0);
            }})
            .addTemplate(P_2_3, new Rule() {{
                add("x", 2);
                add("y", 3);
            }})
            .addTemplate(P_0_3, new Rule() {{
                add("x", 0);
                add("y", 3);
            }})
            .addTemplate(P_2_5, new Rule() {{
                add("x", 2);
                add("y", 5);
            }})
            .addTemplate(P_1_2, new Rule() {{
                add("x", 1);
                add("y", 2);
            }})
            .addTemplate(P_4_4, new Rule() {{
                add("x", 4);
                add("y", 4);
            }})
            .addTemplate(P_2_0, new Rule() {{
                add("x", 2);
                add("y", 0);
            }})
            .addTemplate(P_4_3, new Rule() {{
                add("x", 4);
                add("y", 3);
            }})
            .addTemplate(P_6_5, new Rule() {{
                add("x", 6);
                add("y", 5);
            }})
            .addTemplate(P_3_0, new Rule() {{
                add("x", 3);
                add("y", 0);
            }})
            .addTemplate(P_6_3, new Rule() {{
                add("x", 6);
                add("y", 3);
            }});
    }
}
