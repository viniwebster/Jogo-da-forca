import entities.Scan;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> listWords = new ArrayList<>();
        Scan.Scanner("src/words.txt", listWords);
        Random randomNumber = new Random();

        String word = listWords.get(randomNumber.nextInt(listWords.size())).toLowerCase();
        String[] wordArray = word.split("");

        System.out.println("Bem vindo ao jogo da forca! ");
        System.out.println(word);

        int attempts = 5;
        System.out.println("A palavra contem " + word.length() + " letras");
        System.out.println("Você possui " + attempts + " tentativas");

        System.out.println();
        Arrays.stream(wordArray).forEach(wd -> System.out.print(" _ "));
        System.out.println();

        String[] chute = new String[wordArray.length];

        while (attempts > 0) {
            System.out.print("Digite uma letra: ");
            char letter = sc.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < wordArray.length; i++) {
                if (word.charAt(i) == letter) {
                    chute[i] = String.valueOf(letter);
                    correct = true;
                }
            }

            for (String ch : chute) {
                if (ch != null) {
                    System.out.print(" " + ch + " ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();

            if (!correct) {
                attempts--;
                System.out.println("Você errou, restam " + attempts + " tentativas");
            }

            if (checkWin(chute)) {
                System.out.println("Parabéns, você acertou! A palavra era: " + word.toUpperCase());
                break;
            }
        }
        if (attempts == 0) System.out.println("Você perdeu, a palavra era: " + word.toUpperCase());

        sc.close();
    }

    public static boolean checkWin(String[] list) {
        for (String st : list) {
            if (st == null) {
                return false;
            }
        }
        return true;
    }
}