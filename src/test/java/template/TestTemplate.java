package template;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class TestTemplate {

  @Test
  void oneVariable() {
    Template template = new Template("Hello, ${name}");
    template.set("name", "Abebe");
    assertThat(template.evaluate()).isEqualTo("Hello, Abebe");
  }


  /**
   * Technique is called "triangulation"
   * Referring to how we’re using multiple bearings to pinpoint the implementation toward the proper implementation
   */
  @Test
  void differentValue() {
    Template template = new Template("Hello, ${name}");
    template.set("name", "Kebede");
    assertThat(template.evaluate()).isEqualTo("Hello, Kebede");
  }

  @Test
  void differentTemplate() {
    Template template = new Template("Hi, ${name}"); // different template
    template.set("name", "John");
    assertThat(template.evaluate()).isEqualTo("Hi, John");
  }
}