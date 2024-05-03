import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmpleadoVegetarianoTest.class, EmpleadoNormalTest.class, EmpleadoInfantilTest.class})
class EmpleadoTest {

}