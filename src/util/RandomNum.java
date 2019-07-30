package util;

import java.util.Random;

/**
 * Create by czq
 * time on 2019/7/23  15:33
 */
public class RandomNum {
    public static char getString() {
        Random random = new Random();
        int i = random.nextInt(3);
        char a = 'a';
        switch (i) {
            case 0:
                a = (char) (random.nextInt(10) + 48);
                break;
            case 1:
                a = (char) (random.nextInt(26) + 65);
                break;
            case 2:
                a = (char) (random.nextInt(26) + 97);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getString());
    }
}
