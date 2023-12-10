package console;
public abstract class EnterSrcode {
    private int value;
    public EnterSrcode(int value) {
        this.value = value;
    }
    public abstract void Srval(int value);
    public int getValue() {
        return value;
    }
}
