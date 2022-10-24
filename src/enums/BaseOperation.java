package enums;

public enum BaseOperation {
    PLUS("+"), MINUS("-"), FORGE("/"), MULTIPLY("*");
    private final String value;

    BaseOperation(String value) {
        this.value = value;
    }

    public static BaseOperation getObjectByValue(String value){
        for(BaseOperation baseOperation: BaseOperation.values()){
            if(value.equals(baseOperation.getValue()))
                return baseOperation;
        }
        throw new IllegalArgumentException("Переданная строка в value не содержиться в перечислении.");
    }

    public String getValue(){
        return this.value;
    }
}
