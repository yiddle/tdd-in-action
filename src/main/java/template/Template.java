package template;


import java.util.HashMap;
import java.util.Map;

public class Template {
  private Map<String, String> variables;
  private String variable;
  private String templateText;

  public Template(String templateText) {
    this.templateText = templateText;
    this.variables = new HashMap<>();
  }

  public void set(String variable, String value) {
    this.variables.put(variable, value);
  }

  public String evaluate() {
    String result = templateText;
    for(Map.Entry<String, String> entry: variables.entrySet()) {
      String regex = "\\$\\{"+ entry.getKey() +"}";
      result = result.replaceAll(regex, entry.getValue());
    }

    return result;
  }
}
