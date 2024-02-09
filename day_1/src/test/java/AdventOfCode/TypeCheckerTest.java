package AdventOfCode;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;


public class TypeCheckerTest {

    TypeChecker typeChecker = new TypeChecker();

    @Test
    public void greeterSaysHello() {
        assertThat(typeChecker.checkType("123"), containsString("Numeric"));
        assertThat(typeChecker.checkType("ABS"), containsString("String"));
    }

  }



