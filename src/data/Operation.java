package data;

import enums.BaseOperation;

public class Operation {
    private BaseOperation operation;

    public Operation(BaseOperation operation) {
        this.operation = operation;
    }

    public BaseOperation getOperation() {
        return operation;
    }

    public void setOperation(BaseOperation operation) {
        this.operation = operation;
    }
}
