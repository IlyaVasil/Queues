package lab_14.queues;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ochered iQ;

        while (true) {
            System.out.print("""
                    ====== Меню очередей ======
                                    
                    1. Фиксированная очередь         
                    2. Динамическая очередь
                    3. Кольцевая очередь
                    4. Кольцевая-динамическая очередь
                    0. Выход
                                    
                    Выберите вариант, который хотите использовать:
                    """);
            int choise = sc.nextInt(); // Меню выбора очереди

            if (choise == 1) {
                System.out.print("Выбрана фиксированная очередь\nВведите размер очереди: ");
                int size = sc.nextInt();
                iQ = new FixedQueue(size);
                iQ.printAll();
                QueueUtils.choisedQueueMenu(iQ); // Меню действий с очередью
            }

            if (choise == 2) {
                System.out.println("Выбрана динамическая очередь  \n Введите размер очереди \n");
                int size = sc.nextInt();
                iQ = new DynamicQueue(size);
                QueueUtils.choisedQueueMenu(iQ); // Меню действий с очередью
            }

            if (choise == 3) {
                System.out.println("Выбрана кольцевая очередь\n Введите размер очереди");
                int size = sc.nextInt();
                iQ = new RingQueue(size);
                QueueUtils.choisedQueueMenu(iQ); // Меню действий с очередью
            }

            if (choise == 4) {
                System.out.print("Выбрана кольцевая-динамическая очередь\n Введите размер очереди");
                int size = sc.nextInt();
                iQ = new RingDynamicQueue(size);
                QueueUtils.choisedQueueMenu(iQ); // Меню действий с очередью
            }

            if (choise == 0) {
                System.out.println("Выход из программы");
                break;
            }
        }
    }
}
