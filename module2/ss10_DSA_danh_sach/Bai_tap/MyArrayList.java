import java.util.Arrays;

public class MyArrayList<E> {
    // số lượng phần tử có trong MyArarayList
    private int size = 0;

    // sức chứa của MyArrayList
    private static final int DEFAULT_CAPACITY = 10;

    // mảng chứa các phần tử.
    Object elements[];

    // sức chứa mặc định khi khởi tạo của nó bằng 10.
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // phương thwucs constructor với sức chứa dduwojc truyền vào capacity
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    // method trả về số lượng phần tử
    public int size() {
        return this.size;
    }

    // method clear ArrayList
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;

        }
    }

    // method add 1 phần tử vào MyArrayList
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    //method tăng kích thước của MyArrayList
    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    // method lấy 1 element tại vị trí index.
    public E get(int index) {
        return (E) elements[index];
    }

    // method lấy index của 1 phần tử
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    // method kiểm tra 1 phần tử có trong MyArrayList hay ko
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    //method tạo ra 1 bản sao của MyArrayList hiện tại.
    public MyArrayList<E> clone() {
        MyArrayList<E> v = new MyArrayList<>();
        v.elements = Arrays.copyOf(this.elements, size);
        v.size = this.size;
        return v;
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}