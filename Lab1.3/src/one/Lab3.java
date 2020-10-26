package one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.exit;

public class Lab3 {
    static List list = new List();

    public static void main(String[] args) throws IOException {
        fillList();
        choiceMethod();
    }

    static void choiceMethod() {
        startText();
        int input;
        while((input = Integer.parseInt(inputChoice())) != 0) {
            switch (input) {
                case 0:
                    exit(0);
                case 1:
                    System.out.println("Введите фамилию, чтобы найти соответствующий номер.");
                    list.searchNumber(inputChoice());
                    break;
                case 2:
                    System.out.println("Введите номер телефона, чтобы найти соответсвующую фамилию.");
                    list.searchLastName(inputChoice());
                    break;
                case 3:
                    list.show();
                    break;
            }
            startText();
        }
    }

    static void startText() {
        System.out.println("Нажмите 1 для поиска по фамилии");
        System.out.println("Нажмите 2 для поиска по номеру телефона");
        System.out.println("Нажмите 3 для просмотра списка.");
        System.out.println("Нажмите 0 для завершения программы");
    }

    static void fillList() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Alex/Documents/file.txt"));
        String line;
        String[] bufferArray;
        while((line = bf.readLine()) != null) {
            bufferArray = line.split("\\s+");
            list.add(bufferArray[0],bufferArray[1],bufferArray[2],bufferArray[3]);
        }
    }

    static String inputChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
