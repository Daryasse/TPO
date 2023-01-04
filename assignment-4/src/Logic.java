import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {
    public Model process(String component1, String component2, Pattern pattern){

        Matcher matcher1 = pattern.matcher(component1);
        Matcher matcher2 = pattern.matcher(component2);
        if (!matcher1.matches() | !matcher2.matches()){
            return null;
        }

        else {
            Integer num1 = Integer.parseInt(component1);
            Integer num2 = Integer.parseInt(component2);
            Model model = new Model();
            model.append(num1, num2);
            return model;
        }
    }
}
