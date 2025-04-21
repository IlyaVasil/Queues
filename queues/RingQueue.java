package lab_14.queues;

public class RingQueue implements Ochered {
    private char q[];
    private int putloc, getloc;

    public RingQueue(int size) {
        q = new char[size];
        putloc = getloc = 0;
    }

    public void put(char ch) {
        if (putloc > q.length) {
            char[] t = new char[q.length * 2];
            for (int i = 0; i < q.length; i++) {
                t[i] = q[i];
            }
            q = t;
        }

        q[putloc++] = ch;
        System.out.println("Помещен элемент: " + ch);
    }

    public char get() {
        if (getloc == putloc) {
            System.out.println("- Очередь пуста");
            return (char) 0;

        }
        if (getloc > q.length - 1) {
            System.out.println("- Очередь пуста (за пределами диапазона)");
            return (char) 0;
        }
        char c = q[getloc];
        getloc++;

        if (getloc > q.length) {
            getloc = 0;
        }

        System.out.println("Символ: " + c);
        return c;
    }

    @Override
    public int getSize() {
        return q.length;
    }

    public void reset() {
        putloc = getloc = 0;
        System.out.println("Очередь очищена!");
    }

    public void resetGetloc() {
        getloc = 0;
    }

    public void resetPutloc() {
        putloc = 0;
    }

    @Override
    public void printAll() {
        if (getloc != putloc) {
            for (char c : q) {
                if (c != 0) {
                    System.out.print(c);
                }
            }
        } else System.out.println("Очередь пуста!");

    }


}