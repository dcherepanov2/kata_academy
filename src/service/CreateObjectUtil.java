package service;

import data.Number;
import data.Operation;
import factory.NumberFactory;
import factory.OperationFactory;

public class CreateObjectUtil {
    private static Operation operation;
    private static Number oneNumber;
    private static Number twoNumber;

    public static void createObject(String input){
        operation = OperationFactory.createOperation(input);
        oneNumber = NumberFactory.createNumber(input, 1);
        twoNumber = NumberFactory.createNumber(input, 2);
    }

    public static Operation getOperation() {
        return operation;
    }


    public static Number getOneNumber() {
        return oneNumber;
    }


    public static Number getTwoNumber() {
        return twoNumber;
    }

}
