package factory;

import data.ArabNumber;
import data.Number;
import data.RimNumber;
import enums.BaseOperation;
public class NumberFactory {
    public static Number createNumber(String input, int flag){
        input = input.replace(" ", "");
        int flagLocal = 0;
        if(input.indexOf("-") == 0){
            flagLocal = 1;
            input = input.substring(1);
        }
        switch (flag){
            case 1:
                for (BaseOperation baseOperation: BaseOperation.values()){
                    String baseValueString = baseOperation.getValue();
                    if(input.contains(baseValueString)){
                        input = input.substring(0, input.indexOf(baseOperation.getValue()));
                    }
                }
                if(flagLocal == 1)
                    input = "-" + input;
                break;
            case 2:
                for (BaseOperation baseOperation: BaseOperation.values()){
                    String baseValueString = baseOperation.getValue();
                    if(input.contains(baseValueString)){
                        input = input.substring(input.indexOf(baseOperation.getValue()))
                                     .replace(baseValueString, "");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Аргумент flag не может быть: " + flag + ". Корректное значение: 1, 2.");
            }
            try {
                return new ArabNumber(Integer.parseInt(input));
            }catch (NumberFormatException e){
                return new RimNumber(input);
            }
    }
}
