package data;

public class ArabNumber implements Number{
    private final int value;

    public ArabNumber(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}
