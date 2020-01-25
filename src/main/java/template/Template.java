package template;


public class Template {
  private String variable;

  public Template(String templateText) {

  }

  public void set(String variable, String value) {
    this.variable = value;
  }

  public String evaluate() {
    return String.format("Hello, %s", variable);
  }
}
