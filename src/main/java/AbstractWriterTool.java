public abstract class AbstractWriterTool {

   protected double writingItem = 100;

    public abstract void write(StringBuilder builder, char[] chars);

    public abstract void erase(StringBuilder builder);

    protected abstract double getConsumptionPerChar(int i);

    protected void decreaseWrittingItem (int i){
        writingItem -= getConsumptionPerChar(i);
    }
}
