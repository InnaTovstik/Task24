public class Marker extends AbstractWriterTool {

    private static final double[] INK_CONSUMPTION_PER_CHAR = {1., 1.09, 1.21};

    private int writtenCharCounter;

    @Override
    public String toString() {
        return "Marker{" +
                "writingItem=" + writingItem +
                '}';
    }

    @Override
    public void write(StringBuilder builder, char[] chars) {
        for (char c : chars) {
            builder.append(c);
            writtenCharCounter++;
            if (writtenCharCounter <= 20) {
                decreaseWrittingItem(0);
            } else if (writtenCharCounter <= 40) {
                decreaseWrittingItem(1);
            } else {
                decreaseWrittingItem(2);
            }
        }
    }

    @Override
    public void erase(StringBuilder builder) {
        throw new UnsupportedOperationException("Eraising is not supported by marker");
    }

    @Override
    protected double getConsumptionPerChar(int i) {
        return INK_CONSUMPTION_PER_CHAR[i];
    }
}
