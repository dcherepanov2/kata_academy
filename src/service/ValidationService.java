package service;

import data.ArabNumber;
import data.Operation;
import data.RimNumber;
import data.Number;

public class ValidationService {

    //смысл в том, что если после создания переменных и удаления их из input останутся
    // хоть какие то данные, то пользователь ввел неверную строку
    public static void validateInput(String input, Number number, Number number2, Operation operation) {
        if (number instanceof RimNumber) {
            RimNumber rimNumber = (RimNumber) number;
            input = input.replace(rimNumber.getRimValue(), "");
        } else if (number instanceof ArabNumber)
            input = input.replace(String.valueOf(number.getValue()), "");

        if (number2 instanceof ArabNumber)
            input = input.replace(String.valueOf(number2.getValue()), "");
        else if (number2 instanceof RimNumber) {
            RimNumber rimNumber = (RimNumber) number2;
            input = input.replace(rimNumber.getRimValue(), "");
        }

        input = input.replace(" ", "")
                .replace(operation.getOperation().getValue(), "");
        if (!input.equals(""))
            throw new IllegalArgumentException("Некорректный формат данных");
    }

    public static void validateFormat(Number number, Number number1) {
        if (number instanceof ArabNumber && number1 instanceof RimNumber)
            throw new IllegalArgumentException("Числа должны быть одного формата. Проверьте корректность ввода.");
        else if (number instanceof RimNumber && number1 instanceof ArabNumber)
            throw new IllegalArgumentException("Числа должны быть одного формата. Проверьте корректность ввода.");
    }
}