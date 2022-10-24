package service;

import data.Number;
import data.Operation;
import data.RimNumber;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

public class UserNumberExecutor {
    private int multiplyTwoNumber(Number number, Number number2){
        return number.getValue() * number2.getValue();
    }
    private int minusTwoNumber(Number number, Number number2){
        return number.getValue() - number2.getValue();
    }
    private int plusTwoNumber(Number number, Number number2){
        return number.getValue() + number2.getValue();
    }
    private int forgeTwoNumber(Number number, Number number2){
        return number.getValue() / number2.getValue();
    }

    public static String calc(String input){
        CreateObjectUtil.createObject(input);
        Number number = CreateObjectUtil.getOneNumber();
        Number number1 = CreateObjectUtil.getTwoNumber();
        Operation operation = CreateObjectUtil.getOperation();
        ValidationService.validateInput(input, number, number1, operation);
        ValidationService.validateFormat(number, number1);
        UserNumberExecutor userNumberExecutor = new UserNumberExecutor();
        int result = userNumberExecutor.executeNumberOperation(number, number1, operation);
        if (number instanceof RimNumber && number1 instanceof RimNumber)
            return RimNumber.intToRoman(result);
        return String.valueOf(result);
    }

    private int executeNumberOperation(Number oneNumber, Number twoNumber,Operation operation) {
        switch (operation.getOperation().getValue()){
            case "*":
                return multiplyTwoNumber(oneNumber, twoNumber);
            case "/":
                return forgeTwoNumber(oneNumber, twoNumber);
            case "+":
                return plusTwoNumber(oneNumber, twoNumber);
            case "-":
                return minusTwoNumber(oneNumber, twoNumber);
            default:
                throw new InternalException("Произошла внутренняя ошибка, напишите разработчику по этому вопросу.");
        }
    }
}
