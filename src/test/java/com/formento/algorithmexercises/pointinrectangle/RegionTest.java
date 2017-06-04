package com.formento.algorithmexercises.pointinrectangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.formento.algorithmexercises.pointinrectangle.template.RegionTemplate;
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

}
