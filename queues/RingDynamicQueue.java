package lab_14.queues;

public class RingDynamicQueue implements Ochered {
    private char[] q;
    private int getloc;
    private int putloc;
    private int size;
    private int capacity;

    public RingDynamicQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            System.out.println("Начальная емкость должна быть положительной!");
        }
        capacity = initialCapacity;
        q = new char[capacity];
        getloc = 0;
        putloc = 0;
        size = capacity;
    }

    @Override
    public void put(char ch) {
        if (size > capacity) {
            char[] newQ = new char[capacity * 2];
            for (int i = 0; i < size; i++) {
                newQ[i] = q[(getloc + i) % capacity];
            }

            q = newQ;
            getloc = 0;
            putloc = size;
            capacity = newQ.length;
        }

        q[putloc] = ch;
        putloc = (putloc + 1) % capacity;
        size++;
    }


    @Override
    public char get() {
        if (size == 0) {
            System.out.println("Очередь пуста.");
            return (char) 0;
        }

        char ch = q[getloc];
        getloc = (getloc + 1) % capacity;
        size--;
        return ch;
    }

    @Override
    public void printAll() {
        if (putloc != getloc) {
            System.out.print("Все элементы очереди: \n");
            for (char c : q) {
                if (c != 0) {
                    System.out.print(c);
                }
            }
        }

    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void reset() {
        getloc = 0;
        putloc = 0;
        size = 0;
    }

    @Override
    public void resetPutloc() {
        putloc = 0;
    }

    @Override
    public void resetGetloc() {
        getloc = 0;
    }

}
