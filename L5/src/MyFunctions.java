public class MyFunctions implements TestingFunctions{

    @Override
    public int greatestCommonDivisor(int a, int b) {
        if(b == 0){
            return a;
        }
        if(a < 0 || b < 0){
            return -1;
        }
        return greatestCommonDivisor(b, a%b);
    }

    @Override
    public void reverseWindow(int[] arr, int index1, int index2){
        if (index1 > index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }if (index2 > arr.length || index1 < 0) {
            throw new IndexOutOfBoundsException("OutofBounds");
        }
            int middle = (index2 - index1 - 1)/2;
            for(int i = index1, j = index2 - 1; i <= middle; i++, j--){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    }
}
