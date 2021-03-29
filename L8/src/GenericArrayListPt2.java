import java.util.List;
import java.util.ArrayList;


public class GenericArrayListPt2 <T>{
    public T[] data;

    private int size;

    @SuppressWarnings("unchecked")
    private void resizeData(int newSize) {
        T[] temp = (T[]) new Comparable[newSize];
        for(int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        this.data = temp;
    }

    @SuppressWarnings("unchecked")
    public GenericArrayListPt2(int initialCapacity) {
        this.size = 0;
        this.data = (T[]) new Comparable[initialCapacity];

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

    public boolean contains(String str) {
        for(int i = 0; i < size; i++){
            if(data[i].equals(str)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       

        /* PART 2:
         * Now, modify your GenericArrayList again so that it can only store
         * things that are comparable to a Point.
         *
         * If you don't know how to do this, reference zybooks and your textbook
         * for help.
         *
         * When you are ready to test it, uncomment the code above and run the
         * code below.
         */


        GenericArrayListPt2<Point> pointList = new GenericArrayListPt2<Point>(2);
        GenericArrayListPt2<Point3D> pointList3D = new GenericArrayListPt2<Point3D>(3);

        pointList.add(new Point(0, 0));
        pointList.add(new Point(2, 2));
        pointList.add(new Point(7, 0));
        pointList.add(new Point(19.16f, 22.32f));

        pointList3D.add(new Point3D(1.0f, 2.0f, 3.0f));
        pointList3D.add(new Point3D(7.3f, 4, 0));

        Point p =  pointList.get(2);
       Point3D p3 =  pointList3D.get(0);

        // You should get a compilation error on this line! - Why?
        //GenericArrayListPt2<Float> floatList = new GenericArrayList<Float>(2);

    }
}

