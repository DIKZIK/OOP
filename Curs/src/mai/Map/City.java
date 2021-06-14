package mai.Map;

import mai.PizzaSystem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class City {
    private static int max = Integer.MAX_VALUE;
    private static int size = 4;
    static int[][] distance = {
            {0, 0, 10, 0},
            {0, 0, 5, 0},
            {10, 5, 0, 50},
            {0, 0, 50, 0},
    };
    Scanner input = new Scanner(System.in);
    public static final ArrayList<String> nameDistricts = new ArrayList<>();
    static int courierDistrict = 0;

    public City() {
        nameDistricts.add("Пиццерия");
        nameDistricts.add("Войковская");
        nameDistricts.add("Молодежная");
        nameDistricts.add("Театральная");
    }

    public String makeRoad(int dest) {

        int[] minDist = new int[size];       // минимальное расстояние
        int[] districtVisited = new int[size];       // посещенные вершины
        int temp;
        int minIndex;
        int min;
        int begin_index = courierDistrict;
        //Инициализация вершин и расстояний
        for (int i = 0; i < size; i++) {
            minDist[i] = max;
            districtVisited[i] = 1;
        }
        minDist[begin_index] = 0;
        // Шаг алгоритма
        do {
            minIndex = max;
            min = max;
            for (int i = 0; i < size; i++) { // Если вершину ещё не обошли и вес меньше min
                if ((districtVisited[i] == 1) && (minDist[i] < min)) { // Переприсваиваем значения
                    min = minDist[i];
                    minIndex = i;
                }
            }
            // Добавляем найденный минимальный вес
            // к текущему весу вершины
            // и сравниваем с текущим минимальным весом вершины
            if (minIndex != max) {
                for (int i = 0; i < size; i++) {
                    if (distance[minIndex][i] > 0) {
                        temp = min + distance[minIndex][i];
                        if (temp < minDist[i]) {
                            minDist[i] = temp;
                        }
                    }
                }
                districtVisited[minIndex] = 0;
            }
        } while (minIndex < max);

        // Восстановление пути
        int[] ver = new int[size];       // массив посещенных вершин
        int end = dest;         // индекс конечной вершины = 5 - 1
        ver[0] = end;    // начальный элемент - конечная вершина
        int k = 1;           // индекс предыдущей вершины
        int weight = minDist[end]; // вес конечной вершины

        while (end != begin_index) // пока не дошли до начальной вершины
        {
            for (int i = 0; i < size; i++) // просматриваем все вершины
                if (distance[i][end] != 0)        // если связь есть
                {
                    int tempSecond = weight - distance[i][end]; // определяем вес пути из предыдущей вершины
                    if (tempSecond == minDist[i])              // если вес совпал с рассчитанным
                    {                              // значит из этой вершины и был переход
                        weight = tempSecond;             // сохраняем новый вес
                        end = i;                   // сохраняем предыдущую вершину
                        ver[k] = i;            // и записываем ее в массив
                        k++;
                        break;
                    }
                }
        }
        StringBuilder result = new StringBuilder();
        result.append(minDist[dest]).append(" минут").append(" ");
        // Вывод пути (начальная вершина оказалась в конце массива из k элементов)
        System.out.println("\nВывод кратчайшего пути");
        result.append(nameDistricts.get(ver[k - 1]));
        for (int i = k - 2; i >= 0; --i) {
            result.append("->").append(nameDistricts.get(ver[i]));
        }
        System.out.println(result.toString());
        courierDistrict = dest;
        return null;
    }

    public void addPath(boolean checkFile) {
        ++size;
        distance = reSize(distance);
        String newDistrict = null;
        String buffString = null;
        if (!checkFile) {
            boolean flag = true;
            System.out.println("введите название нового района:");
            while (flag) {
                buffString = input.nextLine();
                for (int i = 0; i < nameDistricts.size(); ++i) {
                    if (Objects.equals(nameDistricts.get(i), buffString)) {
                        System.out.println("Такой район уже существует, повторите попытку");
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
            newDistrict = buffString;
            PizzaSystem.commandsAndData.add(newDistrict);
            nameDistricts.add(newDistrict);
            int temp = 0;
            flag = true;
            for (int i = 0; i < size - 1; ++i) {
                flag = true;
                System.out.println("введите расстояние от " + nameDistricts.get(i) + " до " + nameDistricts.get(nameDistricts.size() - 1) + "(0 - отсутствие пути между точками)");
                while (flag) {
                    int buffer;
                    if (input.hasNextInt()) {
                        buffer = input.nextInt();
                        if (buffer < 0) {
                            System.out.println("Расстояние не может быть меньше 0");
                            flag = true;
                            input.nextLine();
                        } else {
                            temp = buffer;
                            String tempString = Integer.toString(temp);
                            PizzaSystem.commandsAndData.add(tempString);
                            flag = false;
                        }
                    } else {
                        System.out.println("Введите целочисленное значение расстояния");
                        flag = true;
                        input.nextLine();
                    }
                }
                distance[i][nameDistricts.size() - 1] = temp;
                distance[nameDistricts.size() - 1][i] = temp;
            }
        } else {
            boolean flag = true;
            System.out.println("введите название нового района:");
            while (flag) {
                buffString = PizzaSystem.commandsFromFile.pollFirst();
                for (int i = 0; i < nameDistricts.size(); ++i) {
                    if (Objects.equals(nameDistricts.get(i), buffString)) {
                        System.out.println("Такой район уже существует, повторите попытку");
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
            newDistrict = buffString;
            PizzaSystem.commandsAndData.add(newDistrict);
            System.out.println(newDistrict);
            nameDistricts.add(newDistrict);
            int temp = 0;
            flag = true;
            for (int i = 0; i < size - 1; ++i) {
                System.out.println("введите расстояние от " + nameDistricts.get(i) + " до " + nameDistricts.get(nameDistricts.size() - 1) + "(0 - отсутствие пути между точками)");
                buffString = PizzaSystem.commandsFromFile.pollFirst();
                System.out.println(buffString);
                while (flag) {
                    try {
                        temp = Integer.parseInt(buffString);
                        if (temp < 0) {
                            flag = true;
                            System.out.println("Расстояние не может быть меньше 0");
                        } else {
                            flag = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введите целочисленное значение расстояния");
                        flag = true;
                    }
                }
                distance[i][nameDistricts.size() - 1] = temp;
                distance[nameDistricts.size() - 1][i] = temp;
            }
        }
    }

    private int[][] reSize(int[][] distance) {
        int[][] newDistance = new int[size][size];
        for (int i = 0; i < distance.length; i++) {
            System.arraycopy(distance[i], 0, newDistance[i], 0, distance[i].length);
        }
        return newDistance;
    }
}

