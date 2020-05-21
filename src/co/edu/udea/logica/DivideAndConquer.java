package co.edu.udea.logica;

public class DivideAndConquer {
    private int[] vector;

    public DivideAndConquer(int[] vector) {
        this.vector = vector;
    }

    public int[] getMinimunValue() {
        int minPos = findMinimumValuePosition(1, vector.length - 1);
        int[] minVector = new int[]{minPos, vector[minPos]};
        return minVector;
    }

    private int findMinimumValuePosition(int begin, int end) {
        int mid, x = 0;
        boolean inRangeLeft, inRangeRight;
        if (begin <= end) {
            mid = (begin + end) / 2;
            inRangeLeft = mid - 1 > 0;//Comprobación de los límites del vector.
            inRangeRight = mid + 1 < vector.length;
            if (inRangeLeft && inRangeRight && vector[mid] < vector[mid + 1] && vector[mid] < vector[mid - 1])
                return mid;
            if (inRangeLeft && vector[mid] < vector[mid - 1]) {
                x = findMinimumValuePosition(mid + 1, end);
            } else if (inRangeRight) {
                x = findMinimumValuePosition(begin, mid - 1);
            }
            return x;
        }
        return 0;
    }

    public String printVector() {
        String strVector = "[";
        if (vector.length > 1) {
            for (int i = 1; i < vector.length; i++)
                strVector += (i == vector.length - 1) ? vector[i] + "]" : vector[i] + ",";
        } else strVector += "]";
        return strVector;
    }

}
