package factory;

import data.Operation;
import enums.BaseOperation;

public class OperationFactory {
    public static Operation createOperation(String nextLine) {
        nextLine = nextLine.substring(1);//т.к. арабское число может начинаться со знака минус
        if (nextLine.contains("+"))
            return new Operation(BaseOperation.getObjectByValue("+"));
        else if (nextLine.contains("-"))
            return new Operation(BaseOperation.getObjectByValue("-"));
        else if (nextLine.contains("*"))
            return new Operation(BaseOperation.getObjectByValue("*"));
        else if (nextLine.contains("/"))
            return new Operation(BaseOperation.getObjectByValue("/"));

        throw new IllegalArgumentException("В текущей версии предусмотрены операции: + - / *");
    }
}
