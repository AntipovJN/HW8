import java.util.Arrays;

public class OwnArrayList<T> implements List<T> {

    private static final int INITIALIZE_CAPACITY = 10;

    private int capacity;
    private int lastIndex;
    private T[] valuesArray;


    public OwnArrayList() {
        valuesArray = (T[]) new Object[INITIALIZE_CAPACITY];
        capacity = INITIALIZE_CAPACITY;
        lastIndex = 0;
    }

    public OwnArrayList(int capacity) {
        valuesArray = (T[]) new Object[capacity];
        this.capacity = capacity;
        lastIndex = 0;

    }

    @Override
    public void add(T value) {
        if (valuesArray.length < lastIndex) {
            capacityIncrease();
        }
        valuesArray[lastIndex] = value;
        lastIndex++;
    }


    @Override
    public void add(T value, int index) {
        if (index >= capacity) {
            capacityIncrease(index);
        }
        valuesArray[index] = value;
    }

    @Override
    public void addAll(List<T> list) {
        if (list.size() <= 0) {
            return;
        }
        capacityIncrease(list.size());
        for (int i = 0; i < list.size(); i++) {
            valuesArray[capacity + i] = list.get(i);
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return valuesArray[index];
    }

    @Override
    public void set(T value, int index) {
        checkIndex(index);
        if (valuesArray[index] == null) {
            throw new RuntimeException("cell with " + index + " index is empty");
        }
        valuesArray[index] =  value;
    }

    @Override
    public T remove(int index) {
        T removedElement = valuesArray[index];
        int capacity = valuesArray.length - index - 1;
       removeElementFromArray(index,capacity);
       lastIndex--;
        return removedElement;
    }

    @Override
    public T remove(T o) {
        T removedElement = null;
        int index = 0;
        for (; index < valuesArray.length; index++) {
            if (valuesArray[index].equals(o)) {
                removedElement = valuesArray[index];
                break;
            }
        }
        int capacity = valuesArray.length - index - 1;
        removeElementFromArray(index, capacity);
        lastIndex--;
        return removedElement;
    }

    private void removeElementFromArray(int index, int capacity) {
        if (capacity > 0) {
            System.arraycopy(valuesArray, index + 1, valuesArray, index, capacity);
        } else {
            throw new RuntimeException("Cant remove element");
        }
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    private void capacityIncrease() {
        capacity += capacity >> 1;
        valuesArray = Arrays.copyOf(valuesArray, capacity);
    }

    private void capacityIncrease(int length) {
        if (length <= capacity) {
            throw new IllegalArgumentException("New capacity to small");
        }
        capacity += length;
        valuesArray = Arrays.copyOf(valuesArray, capacity);
          }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new RuntimeException("can't use negative index");
        }
        if (index > lastIndex) {
            throw new RuntimeException("can't find object by index");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnArrayList<?> that = (OwnArrayList<?>) o;

        if (capacity != that.capacity) return false;
        if (lastIndex != that.lastIndex) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(valuesArray, that.valuesArray);
    }

    @Override
    public int hashCode() {
        int result = INITIALIZE_CAPACITY;
        result = 31 * result + capacity;
        result = 31 * result + lastIndex;
        result = 31 * result + Arrays.hashCode(valuesArray);
        return result;
    }

    @Override
    public String toString() {
        return "ownArrayList{" +
                "INITIALIZE_CAPACITY=" + INITIALIZE_CAPACITY +
                ", capacity=" + capacity +
                ", lastIndex=" + lastIndex +
                ", valuesArray=" + Arrays.toString(valuesArray) +
                '}';
    }
}
