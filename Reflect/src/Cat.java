/**
 * 为了演示方便，代码并不一定规范，实际开发不要参考
 */
public class Cat extends Animal {
    public String species;
    private boolean isKitten;

    public boolean isKitten() {
        return isKitten;
    }

    public void setKitten(boolean kitten) {
        isKitten = kitten;
    }

    private void testForPrivateMethod() {
    }

    private void printParameters(String value, int num) {
        System.out.println("private method printParameters, param value: " + value + ", num: " + num);
    }

    private String nickName = "Haha";

    public String getNickName() {
        return nickName;
    }

    private final String finalField = "finalValue";
    public String getFinalField() {
        return finalField;
    }

    private static String staticField = "staticField";
}
