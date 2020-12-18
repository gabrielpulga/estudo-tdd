package one;

import one.camelCaseConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class camelCaseConverterTest {

    private camelCaseConverter camelCase;

    @Before
    public void setup() {
        camelCase = new camelCaseConverter();
    }

    @Test
    public void createsCamelCaseConverter() throws Exception {
    }


    @Test
    public void mustConvertSimpleNameToCamelCase() throws Exception {
        camelCaseConverter camelCase = new camelCaseConverter();
        Assert.assertEquals("Lionel", camelCase.convert("lionel"));
    }

    @Test
    public void mustConvertComplexNameToCamelCase() throws Exception {
        Assert.assertEquals("Lionel", camelCase.convert("lIOnel"));
    }
}