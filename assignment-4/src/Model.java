public class Model {
    Integer sum = 0;

    public void append(Integer component1, Integer component2) {
        sum = component1 + component2;
    }

    public Integer getSum() {
        return sum;
    }
}
