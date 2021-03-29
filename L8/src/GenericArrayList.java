import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class GenericArrayList <T>{
    public T[] data;

    private int size;

    @SuppressWarnings("unchecked")
    private void resizeData(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        for(int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        this.data = temp;
    }

    @SuppressWarnings("unchecked")
    public GenericArrayList(int initialCapacity) {
        this.size = 0;
        this.data = (T[]) new Object[initialCapacity];

    }

    @SuppressWarnings("unchecked")
    public void add(Object obj) {
        if(size == data.length){
            resizeData(size * 2);
        }
        data[size] = (T) obj;
        size++;

    }

    @SuppressWarnings("unchecked")
    public void add(int index, Object obj) {
        if (index == size + 1){
            add(obj);
        }else if(index > size) {
        }else{
            for (int i = size; i > index; i--){
                data[i] = data[i - 1];
            }
            data[index] = (T) obj;
            size++;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index > size - 1){
            return null;
        }
        return data[index];
    }

    @SuppressWarnings("unchecked")
    public void remove(int index) {
        if(index > size) {
        }else{
            for (int i = index; i < size - 1; i++){
                data[i] = data[i + 1];
            }
            size--;
        }

    }

    public int size() {
        return size;
    }

    public boolean contains(Object obj) {
        for(int i = 0; i < size; i++){
            if(data[i].equals(obj)){
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        /* PART 1:
         * Modify the GenericArrayList above so that it can store *any* class,
         * not just strings.
         * When you've done that, uncomment the block of code below, and see if
         * it compiles. If it does, run it. If there are no errors, you did
         * it right!
         */


        GenericArrayList<Point> pointList = new GenericArrayList<Point>(2);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList.remove(0);
        Point p = pointList.get(2);

       if (p.x != 19.16f && p.y != 22.32f) {
            throw new AssertionError("Your GenericArrayList compiled properly "
            + "but is not correctly storing things. Make sure you didn't "
            + "accidentally change any of your ArrayStringList code, aside "
            + "from changing types.");
        }

        GenericArrayList<Float> floatList = new GenericArrayList<Float>(2);

        for (float f = 0.0f; f < 100.0f; f += 4.3f) {
            floatList.add(f);
        }

        float f = floatList.get(19);

        System.out.println("Hurray, everything worked!");

    }
}

