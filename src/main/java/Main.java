//В функции main должен быть реализован следующий алгоритм:
//создания массива рандомных пишущих средств размером в 10 элементов и подготовка их к работе.
// создание StringBuilder и далее передаем его в функцию писать для сохранения в него текста.
// 10 кратное написание в созданный StringBuilder рандомной цепочки символов от 3 до 5 символов каждым из устройств,
// если устройство умеет стирать, то стираем последний символ в каждой итерации.
// сортировка устройств по остатку пишущего средства в % и вывод массива в System.out.

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    private static final int OBJECTS_COUNT = 10;
    private static final int NUMBER_SPELLING = 10;
    private static final int MIN_CHARS_COUNT = 3;
    private static final int MAX_CHARS_COUNT = 5;
    private static AbstractWriterTool[] writerTools = new AbstractWriterTool[OBJECTS_COUNT];

    public static void main(String[] args) throws
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException {

        createArrayWriterTool();
        writeAndErase();
// сортировка устройств по остатку пишущего средства в % и вывод массива в System.out.
        Arrays.sort(writerTools, Comparator.comparingDouble(o -> o.writingItem));
        System.out.println(Arrays.toString(writerTools));
    }

    //создания массива рандомных пишущих средств размером в 10 элементов и подготовка их к работе.
    private static void createArrayWriterTool() throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<? extends AbstractWriterTool>[] classes = new Class[]{
                Pen.class,
                Pencil.class,
                Marker.class
        };
        for (int i = 0; i < OBJECTS_COUNT; i++) {
            Random r = new Random();
            int ind = r.nextInt(3);
            Constructor<? extends AbstractWriterTool> constructor = classes[ind].getConstructor();
            Object[] arguments = new Object[]{};
            AbstractWriterTool writerTool = constructor.newInstance(arguments);
            writerTools[i] = writerTool;
        }
    }

    // создание StringBuilder и далее передаем его в функцию писать для сохранения в него текста.
    // 10 кратное написание в созданный StringBuilder рандомной цепочки символов от 3 до 5 символов каждым из устройств,
    // если устройство умеет стирать, то стираем последний символ в каждой итерации.
    private static void writeAndErase() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < OBJECTS_COUNT; i++) {
            for (int j = 0; j < NUMBER_SPELLING; j++)
                writerTools[i].write(stringBuilder, getChars());
            try {
                writerTools[i].erase(stringBuilder);
            } catch (UnsupportedOperationException e) {
                e.getMessage();
            }
        }
    }


    // generation char[] рандомной цепочки от 3 до 5 символов
    private static char[] getChars() {
        int charCount = (int) (MIN_CHARS_COUNT + Math.random() * (MAX_CHARS_COUNT - MIN_CHARS_COUNT + 1));
        char[] myChar = new char[charCount];
        for (int j = 0; j < myChar.length; j++) {
            myChar[j] = getRandomChar();
        }
        return myChar;
    }

    // generation char
    private static char getRandomChar() {
        Random random = new Random();
        int codePoint;
        while (!Character.isAlphabetic(codePoint = random.nextInt(127))) ;
        return (char) codePoint;
    }
}