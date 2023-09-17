package base;

import org.testng.annotations.BeforeClass;
import steps.base.BaseSteps;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void init() {
        BaseSteps.init();
    }
}
