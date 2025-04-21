package lab_14.queues;

public class DynamicQueue implements Ochered {
    private char q[];
    private int putloc, getloc; // Начало и конец очереди

    public DynamicQueue(int size) {
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
            System.out.println("\nОчередь пуста");
            return '\0';
        }
        getloc = (getloc + 1) % q.length;
        return q[getloc];
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

        if (putloc != getloc) {
            System.out.print("Все элементы очереди: \n");
            for (char c : q) {
                if (c != 0) {
                    System.out.print(c);
                }
            }
        }
    }


}