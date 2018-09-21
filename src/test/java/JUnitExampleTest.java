import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JUnitExampleTest {

    @Test

    public void twoPlusTwoEqualsFour() {

        assertEquals("Addition should be done correctly: 2+2=4", 4, 2+2);
    }
}
