package template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import template.exception.MissingValueException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TestTemplate {

  private Template template;

  @BeforeEach
  public void setUp() {
    template = new Template("${one} ${two} ${three}");
    template.set("one", "1");
    template.set("two", "2");
    template.set("three", "3");
  }



  @Test
  void multipleVariables() {
    assertThat(template.evaluate()).isEqualTo("1 2 3");
  }


  @Test
  void unknownVariablesIgnored() throws Exception{
    template.set("doesnotexist", "alksdlak");
    assertThat(template.evaluate()).isEqualTo("1 2 3");
  }


  @Test
  void testMissingValueRaisesException() {
    Template template = new Template("${non-existing-var}");
    assertThatThrownBy(() -> {
      String result = template.evaluate();
    }).isInstanceOf(MissingValueException.class);
  }

}
