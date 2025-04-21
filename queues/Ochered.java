package lab_14.queues;

public interface Ochered {
    
    void put(char ch);

    char get();

    void printAll();

    int getSize();

    void reset();

    void resetPutloc();
    void resetGetloc();
    static void copy(Ochered origin, Ochered destination) {
        for (int i = 0; i < Math.min(origin.getSize(), destination.getSize()); i++) {
            destination.put(origin.get());
        }

        System.out.println("Копирование успешно!");
    }

}


