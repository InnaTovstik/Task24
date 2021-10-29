public class Pencil extends AbstractWriterTool{

    private static final double[] INK_CONSUMPTION_PER_CHAR =  {0.15, 3};
    private int writtenCharCounter;

    @Override
    public String toString() {
        return "Pencil{" +
                "writingItem=" + writingItem +
                '}';
    }

    @Override
    public void write(StringBuilder builder, char[] chars) {
        for(char c : chars){
            builder.append(c);
            decreaseWrittingItem(0);
            writtenCharCounter++;
            if (writtenCharCounter % 20 == 0){
                sharpen();
            }
        }
    }

    private void sharpen() {
        writingItem -= INK_CONSUMPTION_PER_CHAR[1];
    }

    @Override
    public void erase(StringBuilder builder) {
        builder.deleteCharAt(builder.length()-1);
    }

        @Override
    protected double getConsumptionPerChar(int i) {
        return INK_CONSUMPTION_PER_CHAR[i];
    }
}
