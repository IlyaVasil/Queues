package lab_14.queues;

import java.util.Random;
import java.util.Scanner;

public class QueueUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    static void inputQueue(Ochered iQ) {
        while (true) {
            System.out.print(
                    """
                            \nВыбрано заполнение очереди
                                                        
                            1. Автоматическое заполнение
                            2. Заполнение вручную
                            0. Выход
                                                       
                            Ваш выбор:
                            """
            );
            int input = SCANNER.nextInt();


            if (input == 1) {
                System.out.println("Вы выбрали заполнение автоматически");
                int initialSize = iQ.getSize();
                for (int i = 0; i < initialSize; i++) {
                    Random r = new Random();
                    char c = (char) (r.nextInt(26) + 'a');
                    iQ.put(c);
                }
                iQ.printAll();

            } else if (input == 2) {
                System.out.print("Вы выбрали заполнение вручную\nВведите значение: ");
                int initialSize = iQ.getSize();
                for (int i = 0; i < initialSize; i++) {
                    char ch = SCANNER.next().charAt(0);
                    iQ.put(ch);
                }
                System.out.println("Помещенные элементы в очередь: \n");
                iQ.printAll();

            } else if (input == 0) {
                break;
            } else {
                System.out.println("Неверный ввод!\nПовторите ввод: ");
            }
        }
    }

    static void getElementQueue(Ochered iQ) {
        System.out.println("===== Выбрано извлечение элементов из очереди =====");

        for (int i = 0; i < iQ.getSize(); i++) {
            System.out.println(iQ.get());
        }
    }
    static void choisedQueueMenu(Ochered iQ) {
        while (true) {
            System.out.print(""" 
                               
                    1. Заполнить очередь
                    2. Удалить из очереди
                    3. Копировать очередь
                    4. Вывести все элементы
                    5. Очистить очередь
                    0. Выход
                    
                    Выберите что хотите сделать:
                    """);
            int fixedqueuechoise = SCANNER.nextInt();

            if (fixedqueuechoise == 1) // Помещение элементов в очередь
            {
                QueueUtils.inputQueue(iQ);

            } else if (fixedqueuechoise == 2) {
                QueueUtils.getElementQueue(iQ);
            } else if (fixedqueuechoise == 3) {
                System.out.println("Выбрано копирование очереди:");
                iQ.printAll();
                System.out.println("\nВведите размер новой очереди :");

                int copysize = SCANNER.nextInt();

                FixedQueue iQ1 = new FixedQueue(copysize); // Создание новой очереди

                Ochered.copy(iQ, iQ1); // Копирование очередей
                System.out.println("Скопированная очередь: ");
                iQ1.printAll();

            } else if (fixedqueuechoise == 4) {
                System.out.println("Вывод всех элементов очереди");
                iQ.printAll();

            } else if (fixedqueuechoise == 5) {
                System.out.println("Выбрано очищение очереди");
                iQ.reset();
                System.out.println("Очередь очищена!");
                iQ.get();
            }
            if (fixedqueuechoise == 0) {
                break;
            }
        }
    }
}



