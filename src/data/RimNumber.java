package data;

import java.util.*;

public class RimNumber implements Number {
    private final int value;
    private final String rimValue;

    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

    public RimNumber(String number) {
        this.value = this.romanToInteger(number);
        this.rimValue = number;// не делал валидацию ввода в number, т.к. метод все равно упадет,
                               // если там будет какая-то ерунда в инпуте)
    }

    public static String intToRoman(int value) {
        if (value > 4000 || value < 1)
            throw new IllegalArgumentException("В результате операции над римскими числами не может получиться производная меньше 1");
        StringBuilder result = new StringBuilder();
        for (Integer key : units.descendingKeySet()) {
            while (value >= key) {
                value -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private int romanToInteger(String roman) {
        Map<Character, Integer> numbersMap = new HashMap<>();
        numbersMap.put('I', 1);
        numbersMap.put('V', 5);
        numbersMap.put('X', 10);
        numbersMap.put('L', 50);
        numbersMap.put('C', 100);
        numbersMap.put('D', 500);
        numbersMap.put('M', 1000);
        int result = 0;
        numbersMap.forEach((key, value1) -> {//проверка того, что не была передана строка IIII или IVVVV,
                                             // в римской системе счисления предусмотрены только числа содержащие 3 одинаковые цифры идущие подряд
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                stringBuilder.append(key);
            }
            if(roman.contains(stringBuilder.toString()))
                throw new IllegalArgumentException("Некорректный формат введенной римской цифры: " + stringBuilder);
        });
        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);
            if (i > 0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(i - 1))) {
                result += numbersMap.get(ch) - 2 * numbersMap.get(roman.charAt(i - 1));
            } else
                result += numbersMap.get(ch);
        }
        return result;
    }

    private static final NavigableMap<Integer, String> units;


    @Override
    public int getValue() {
        return value;
    }

    public String getRimValue() {
        return rimValue;
    }
}
    