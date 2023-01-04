public enum Mode {
    write("WRITE", 1),
    read("READ", 0);
    private final String value;
    private final int mark;

    private Mode(String value, int mark) {
        this.value = value;
        this.mark = mark;
    }
    public static Mode getMode(String value) {
        if (value.equalsIgnoreCase(write.getValue())) {
            return write;
        } else if (value.equalsIgnoreCase(read.getValue())) {
            return read;
        } else {
            return null;
        }
    }
    public String getValue() { return value; }
    public int getMark() {return mark; }
}
