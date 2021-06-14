package mai;

import mai.user.*;
import mai.Map.*;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PizzaSystem {

    private static final String REG_CHOOSE = "reg";
    private static final String ENTER_CHOOSE = "ent";
    private static final String END_CHOOSE = "end";
    private static final String YES_CHOOSE = "yes";
    private static final String NO_CHOOSE = "no";
    private static final String ADM_CHOOSE = "admin";
    private static final String REPEAT_CHOOSE = "rep";
    private static final String MAIN_MENU = "Выберите команду: \n[reg] - регистрация нового пользователя\n[ent] - вход в личный кабинет\n[admin] - admin\n[end] - завершение работы";
    private static final int NUMBER_OF_ARGS = 2;
    static HashMap<String, Client> users = new HashMap<>();
    public static Deque<String> commandsFromFile = new LinkedList<>();
    public static LinkedList<String> commandsAndData = new LinkedList<>();
    static Scanner input = new Scanner(System.in);
    static City city = new City();
    static Admin admin = new Admin("ADMIN", "admin", "admin");

    public static void main(String[] args) throws IOException {
        if (args.length == NUMBER_OF_ARGS
                && (args[0].equalsIgnoreCase("-f") || args[0].equalsIgnoreCase("--file"))) {
            try (BufferedReader bufReader = new BufferedReader(new FileReader(args[1]))) {
                String s;
                while ((s = bufReader.readLine()) != null) {
                    commandsFromFile.add(s);
                }
                mainRunFile();
            } catch (IOException e) {
                System.out.println("Файл не найден. Проверьте правильность имени и повторите попытку.");
                mainMenu();
            }
        } else {
            mainMenu();
        }
    }

    private static void mainMenu() throws IOException {
        String choose = "";
        while (!choose.equals(END_CHOOSE)) {
            System.out.println(MAIN_MENU);
            choose = input.nextLine().toLowerCase();
            if (!choose.equals(END_CHOOSE)) {
                commandsAndData.add(choose);
            }
            switch (choose) {
                case REG_CHOOSE -> {
                    System.out.println("Введите имя: ");
                    String nickname = input.nextLine();
                    commandsAndData.add(nickname);
                    System.out.println("Введите логин: ");
                    String login = input.nextLine();
                    commandsAndData.add(login);
                    System.out.println("Введите пароль: ");
                    String password = input.nextLine();
                    commandsAndData.add(password);
                    System.out.println("Выберите номер вашего района: ");
                    StringBuilder bufferDistricts = new StringBuilder();
                    for (int i = 0; i < City.nameDistricts.size(); i++) {
                        bufferDistricts.append(i + 1).append(") ").append(City.nameDistricts.get(i)).append("\n");
                    }
                    System.out.print(bufferDistricts.toString());
                    int district = 0;
                    boolean flag = true;
                    while (flag) {
                        int buffer;
                        if (input.hasNextInt()) {
                            buffer = input.nextInt();
                            if (buffer < 1 || buffer > City.nameDistricts.size()) {
                                System.out.println("Такого района не существует, повторите попытку:");
                                flag = true;
                                input.nextLine();
                            } else {
                                district = buffer;
                                flag = false;
                            }
                        } else {
                            System.out.println("Такого района не существует, повторите попытку:");
                            flag = true;
                            input.nextLine();
                        }
                    }
                    String districtString = Integer.toString(district);
                    commandsAndData.add(districtString);
                    input.nextLine();
                    users.put(login, new Client(nickname, login, password, district - 1));
                }
                case ENTER_CHOOSE -> {
                    System.out.println("Введите логин: ");
                    String takeLogin = input.nextLine();
                    commandsAndData.add(takeLogin);
                    if (users.containsKey(takeLogin)) {
                        boolean correctPassword = true;
                        do {
                            System.out.println("Введите пароль: ");
                            String takePassword = input.nextLine();
                            commandsAndData.add(takePassword);
                            if (users.get(takeLogin).enter(takeLogin, takePassword)) {
                                correctPassword = false;
                                System.out.println("Вход выполнен!");
                                System.out.println("Хотите заказать пиццу? [yes] - Да / [no] - Нет");
                                boolean isYesOrNo = true;
                                do {
                                    String takeCommand = input.nextLine().toLowerCase();
                                    commandsAndData.add(takeCommand);
                                    if (takeCommand.equals(YES_CHOOSE)) {
                                        city.makeRoad(users.get(takeLogin).getDist());
                                        isYesOrNo = false;
                                    } else if (takeCommand.equals(NO_CHOOSE)) {
                                        System.out.println("Заказ пиццы отменён");
                                        isYesOrNo = false;
                                    } else {
                                        System.out.println("Неизвестый выбор, повторите попытку!");
                                        isYesOrNo = true;
                                    }
                                } while (isYesOrNo);
                            } else {
                                System.out.println("Неверный пароль!");
                                System.out.println("[rep] - Повторить попытку / [end] - Выйти");
                                String commandPass = input.nextLine().toLowerCase();
                                commandsAndData.add(commandPass);
                                if (commandPass.equals(REPEAT_CHOOSE)) {
                                    correctPassword = true;
                                } else if (commandPass.equals(END_CHOOSE)) {
                                    correctPassword = false;
                                } else {
                                    System.out.println("Неизвестная команда, завершаем работу!");
                                    correctPassword = false;
                                }
                            }
                        } while (correctPassword);
                    } else {
                        System.out.println("Такого логина нет в базе");
                    }
                }
                case ADM_CHOOSE -> {
                    System.out.println("Введите логин: ");
                    String takeLogin = input.nextLine();
                    commandsAndData.add(takeLogin);
                    if (takeLogin.equals(admin.getLogin())) {
                        boolean correctPassword = true;
                        do {
                            System.out.println("Введите пароль: ");
                            String takePassword = input.nextLine();
                            commandsAndData.add(takePassword);
                            if (takePassword.equals(admin.getPassword())) {
                                correctPassword = false;
                                System.out.println("Вход выполнен!");
                                System.out.println("Хотите добавить новый район? [yes] - Да / [no] - Нет");
                                boolean isYesOrNo = true;
                                do {
                                    String takeCommand = input.nextLine().toLowerCase();
                                    commandsAndData.add(takeCommand);
                                    if (takeCommand.equals(YES_CHOOSE)) {
                                        city.addPath(false);
                                        isYesOrNo = false;
                                    } else if (takeCommand.equals(NO_CHOOSE)) {
                                        System.out.println("Выход в главное меню...");
                                        isYesOrNo = false;
                                    } else {
                                        System.out.println("Неизвестый выбор, повторите попытку!");
                                        isYesOrNo = true;
                                    }
                                } while (isYesOrNo);
                            } else {
                                System.out.println("Неверный пароль!");
                                System.out.println("[rep] - Повторить попытку / [end] - Выйти");
                                String commandPass = input.nextLine().toLowerCase();
                                commandsAndData.add(commandPass);
                                if (commandPass.equals(REPEAT_CHOOSE)) {
                                    correctPassword = true;
                                } else if (commandPass.equals(END_CHOOSE)) {
                                    correctPassword = false;
                                } else {
                                    System.out.println("Неизвестная команда, завершаем работу!");
                                    correctPassword = false;
                                }
                            }
                        } while (correctPassword);
                    }
                }
                case END_CHOOSE -> {
                    System.out.println("[yes] - Сохранить данные в файл");
                    System.out.println("[no] - Завершить работу программы без сохранения");
                    String save = input.nextLine().toLowerCase();
                    if (save.equals(YES_CHOOSE)) {
                        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
                        File myFile = new File("result_" + timeStampPattern.format(java.time.LocalDateTime.now()) + ".txt");
                        FileWriter writer = null;
                        try {
                            writer = new FileWriter(myFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (String strAdd : commandsAndData) {
                            assert writer != null;
                            writer.write(strAdd);
                            writer.write(System.lineSeparator());
                        }
                        assert writer != null;
                        writer.flush();
                        writer.close();
                        System.out.println("Команды сохранены в файл.");
                    } else if (save.equals(NO_CHOOSE)) {
                        System.out.println("Команды не сохранены в файл.");
                    } else {
                        System.out.println("Неизвестная команда, данные не сохранены в файл.");
                    }
                }
                default -> System.out.println("Такой команды нет");
            }
        }
    }

    private static void mainRunFile() throws IOException {
        String command = null;
        if (!commandsFromFile.isEmpty()) {
            command = commandsFromFile.pollFirst();
        } else {
            System.out.println("Файл пуст");
            mainMenu();
        }
        while (!commandsFromFile.isEmpty()) {
            System.out.println(MAIN_MENU);
            System.out.println(command);
            switch (Objects.requireNonNull(command)) {
                case REG_CHOOSE -> {
                    System.out.println("Введите имя: ");
                    command = commandsFromFile.pollFirst();
                    String name = command;
                    System.out.println(command);
                    commandsAndData.add(command);
                    System.out.println("Введите логин: ");
                    command = commandsFromFile.pollFirst();
                    String login = command;
                    System.out.println(command);
                    commandsAndData.add(command);
                    System.out.println("Введите пароль: ");
                    command = commandsFromFile.pollFirst();
                    String password = command;
                    System.out.println(command);
                    commandsAndData.add(command);
                    System.out.println("Выберите номер вашего района: ");
                    StringBuilder bufferDistricts = new StringBuilder();
                    for (int i = 0; i < City.nameDistricts.size(); i++) {
                        bufferDistricts.append(i + 1).append(") ").append(City.nameDistricts.get(i)).append("\n");
                    }
                    System.out.print(bufferDistricts.toString());
                    command = commandsFromFile.pollFirst();
                    System.out.println(command);
                    commandsAndData.add(command);
                    assert command != null;
                    int district = 0;
                    String buffString = PizzaSystem.commandsFromFile.pollFirst();
                    System.out.println(buffString);
                    try {
                        district = Integer.parseInt(buffString);
                    } catch (NumberFormatException e) {
                        System.out.println("Введите целочисленное значение расстояния");
                    }
                    users.put(login, new Client(name, login, password, district - 1));
                }
                case ADM_CHOOSE -> {
                    System.out.println("Введите логин: ");
                    command = commandsFromFile.pollFirst();
                    String takeLogin = command;
                    System.out.println(takeLogin);
                    commandsAndData.add(takeLogin);
                    if (takeLogin.equals(admin.getLogin())) {
                        boolean correctPassword = true;
                        do {
                            System.out.println("Введите пароль: ");
                            command = commandsFromFile.pollFirst();
                            String takePassword = command;
                            System.out.println(takePassword);
                            commandsAndData.add(takePassword);
                            if (takePassword.equals(admin.getPassword())) {
                                correctPassword = false;
                                System.out.println("Вход выполнен!");
                                System.out.println("Хотите добавить новый район? [yes] - Да / [no] - Нет");
                                boolean isYesOrNo = true;
                                do {
                                    command = commandsFromFile.pollFirst();
                                    String takeCommand = command;
                                    System.out.println(takeCommand);
                                    commandsAndData.add(takeCommand);
                                    if (takeCommand.equals(YES_CHOOSE)) {
                                        city.addPath(true);
                                        isYesOrNo = false;
                                    } else if (takeCommand.equals(NO_CHOOSE)) {
                                        System.out.println("Выход в главное меню...");
                                        isYesOrNo = false;
                                    } else {
                                        System.out.println("Неизвестый выбор, повторите попытку!");
                                        isYesOrNo = true;
                                    }
                                } while (isYesOrNo);
                            } else {
                                System.out.println("Неверный пароль!");
                                System.out.println("[rep] - Повторить попытку / [end] - Выйти");
                                command = commandsFromFile.pollFirst();
                                String commandPass = command;
                                System.out.println(commandPass);
                                commandsAndData.add(commandPass);
                                if (Objects.equals(commandPass, REPEAT_CHOOSE)) {
                                    correctPassword = true;
                                } else if (Objects.equals(commandPass, END_CHOOSE)) {
                                    correctPassword = false;
                                } else {
                                    System.out.println("Неизвестная команда, завершаем работу!");
                                    correctPassword = false;
                                }
                            }
                        } while (correctPassword);
                    }
                }
                case ENTER_CHOOSE -> {
                    System.out.println("Введите логин: ");
                    command = commandsFromFile.pollFirst();
                    String takeLogin = command;
                    System.out.println(takeLogin);
                    commandsAndData.add(takeLogin);
                    if (users.containsKey(takeLogin)) {
                        boolean correctPassword = true;
                        do {
                            System.out.println("Введите пароль: ");
                            command = commandsFromFile.pollFirst();
                            String takePassword = command;
                            System.out.println(takePassword);
                            commandsAndData.add(takePassword);
                            if (users.get(takeLogin).enter(takeLogin, takePassword)) {
                                correctPassword = false;
                                System.out.println("Вход выполнен!");
                                System.out.println("Хотите заказать пиццу? [yes] - Да / [no] - Нет");
                                boolean isYesOrNo = true;
                                do {
                                    command = commandsFromFile.pollFirst();
                                    String takeCommand = command;
                                    System.out.println(takeCommand);
                                    commandsAndData.add(takeCommand);
                                    if (Objects.equals(takeCommand, YES_CHOOSE)) {
                                        city.makeRoad(users.get(takeLogin).getDist());
                                        isYesOrNo = false;
                                    } else if (Objects.equals(takeCommand, NO_CHOOSE)) {
                                        System.out.println("Заказ пиццы отменён");
                                        isYesOrNo = false;
                                    } else {
                                        System.out.println("Неизвестый выбор, повторите попытку!");
                                        isYesOrNo = true;
                                    }
                                } while (isYesOrNo);
                            } else {
                                System.out.println("Неверный пароль!");
                                System.out.println("[rep] - Повторить попытку / [end] - Выйти");
                                command = commandsFromFile.pollFirst();
                                String commandPass = command;
                                System.out.println(commandPass);
                                commandsAndData.add(commandPass);
                                if (Objects.equals(commandPass, REPEAT_CHOOSE)) {
                                    correctPassword = true;
                                } else if (Objects.equals(commandPass, END_CHOOSE)) {
                                    correctPassword = false;
                                } else {
                                    System.out.println("Неизвестная команда, завершаем работу!");
                                    correctPassword = false;
                                }
                            }
                        } while (correctPassword);
                    } else {
                        System.out.println("Такого логина нет в базе");
                    }
                }
                default -> {
                    System.out.println("Ошибка команды");
                    command = commandsFromFile.pollFirst();
                }
            }
        }
        System.out.println("Переход в режим ручного ввода:");
        mainMenu();
    }
}
