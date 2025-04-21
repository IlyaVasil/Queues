package lab_14.queues;


import java.util.Random;
import java.util.Scanner;

public class FixedQueue implements Ochered {
    private char q[];

    private int putloc, getloc;

    public FixedQueue(int size) {
        q = new char[size];
        putloc = getloc = 0;
    }

    public void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" Очередь заполнена");
            return;
        }

        System.out.println("Помещен элемент: " + ch);
        q[putloc++] = ch;
    }

    public char get() {

            if (getloc == putloc) {
                System.out.print("\n- Очередь пуста");
            }

        return q[getloc++];
    }

    @Override
    public int getSize() {
        return q.length;
    }

    public void reset() {
        putloc = getloc = 0;
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

