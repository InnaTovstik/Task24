public class Pen extends AbstractWriterTool{

    private static final double[] INK_CONSUMPTION_PER_CHAR = {0.15};

    @Override
    public String toString() {
        return "Pen{" +
                "writingItem=" + writingItem +
                '}';
    }

    @Override
    public void write(StringBuilder builder, char[] chars) {
        for(char c : chars){
            builder.append(c);
            decreaseWrittingItem(0);
        }
    }

    @Override
    public void erase(StringBuilder builder) {
        throw new UnsupportedOperationException("Eraising is not supported by pen");
    }

    @Override
    protected double getConsumptionPerChar(int i) {
        return INK_CONSUMPTION_PER_CHAR[i];
    }
}
