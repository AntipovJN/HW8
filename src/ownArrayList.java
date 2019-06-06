import java.util.Arrays;

public class ownArrayList<T> implements List {

    private final int INITIALIZE_CAPACITY = 3;

    private int capacity;
    private int newCapacity;
    private int oldCapacity;
    private int lastIndex;
    private T[] valuesArray;


    public ownArrayList() {
        valuesArray = (T[]) new Object[INITIALIZE_CAPACITY];
        this.capacity = INITIALIZE_CAPACITY;
        newCapacity = INITIALIZE_CAPACITY;
        lastIndex = 0;
    }

    public ownArrayList(int capacity) {
        valuesArray = (T[]) new Object[capacity];
        this.capacity = capacity;
        newCapacity = capacity;
        lastIndex = 0;

    }

    @Override
    public void add(Object value) {
        if (valuesArray[capacity - 1] != null) {
            capacityIncrease();
        }
        valuesArray[lastIndex] = (T) value;
        lastIndex++;
    }


    @Override
    public void add(Object value, int index) {
        if (index >= capacity) {
            capacityIncrease(index);
        }
        valuesArray[index] = (T) value;
    }

    @Override
    public void addAll(List list) {
        if (list.size() <= 0) {
            return;
        }
        capacityIncrease(list.size());
        for (int i = 0; i < list.size(); i++) {
            valuesArray[oldCapacity + i] = (T) list.get(i);
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return valuesArray[index];
    }

    @Override
    public void set(Object value, int index) {
        checkIndex(index);
        valuesArray[index] = (T) value;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        int j = 0;
        T[] newArrayOfValues = (T[]) new Object[lastIndex-1];
        T foundedElement = null;
        for (int i = 0; i <= lastIndex - 1; i++) {
            if (i != index) {
                newArrayOfValues[j] = valuesArray[i];
                j++;
            } else {
                foundedElement = valuesArray[i];

            }
        }
        valuesArray = newArrayOfValues;
        lastIndex--;
        return foundedElement;
    }

    @Override
    public T remove(Object o) {
        T foundedElement = null;
        if (o != null) {
            T[] newArrayOfValues = (T[]) new Object[lastIndex-1];
            int j = 0;
            for (int i = 0; i <= lastIndex - 1; i++) {
                if (!valuesArray[i].equals((T) o)) {
                    newArrayOfValues[j] = valuesArray[i];
                    j++;
                } else {
                    foundedElement = valuesArray[i];

                }
            }
            valuesArray = newArrayOfValues;
            lastIndex--;
        } else {
            throw new RuntimeException("object not find");
        }
        return foundedElement;
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public boolean isEmpty() {
        if (valuesArray[0] == null) {
            return true;
        }
        return false;
    }

    private void capacityIncrease() {
        newCapacity += capacity >> 1;
        valuesArray = Arrays.copyOf(valuesArray, newCapacity);
        oldCapacity = capacity;
        capacity = newCapacity;
    }

    private void capacityIncrease(int length) {
        if (length <= capacity) {
            throw new IllegalArgumentException("New capacity to small");
        }
        newCapacity += length;
        valuesArray = Arrays.copyOf(valuesArray, newCapacity);
        oldCapacity = capacity;
        capacity = newCapacity;
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

        ownArrayList<?> that = (ownArrayList<?>) o;

        if (capacity != that.capacity) return false;
        if (newCapacity != that.newCapacity) return false;
        if (oldCapacity != that.oldCapacity) return false;
        if (lastIndex != that.lastIndex) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(valuesArray, that.valuesArray);
    }

    @Override
    public int hashCode() {
        int result = INITIALIZE_CAPACITY;
        result = 31 * result + capacity;
        result = 31 * result + newCapacity;
        result = 31 * result + oldCapacity;
        result = 31 * result + lastIndex;
        result = 31 * result + Arrays.hashCode(valuesArray);
        return result;
    }

    @Override
    public String toString() {
        return "ownArrayList{" +
                "INITIALIZE_CAPACITY=" + INITIALIZE_CAPACITY +
                ", capacity=" + capacity +
                ", newCapacity=" + newCapacity +
                ", oldCapacity=" + oldCapacity +
                ", lastIndex=" + lastIndex +
                ", valuesArray=" + Arrays.toString(valuesArray) +
                '}';
    }
}
