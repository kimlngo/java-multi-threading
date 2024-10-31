
package study;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main3 {
    public static void main(String[] args) {
        Vault vault = new Vault(Constant.MAX_NUM);

        MultiExecutor executor = new MultiExecutor(List.of(
                new AscendingOrderTheft(vault),
                new DescendingOrderTheft(vault),
                new PoliceThread()));
        executor.executeAll();
    }
}

class Constant {
    public static int MAX_NUM = 9999;
    public static int CRACK_DURATION = 4;
}

class Vault {
    private int password;

    public Vault(int max) {
        this.password = new Random().nextInt(max);
        System.out.println("Password for debugging: " + password);
    }

    public boolean isPasswordCorrect(int guess) {
        return password == guess;
    }
}

class AscendingOrderTheft implements Runnable {

    private Vault vault;
    private String name;

    public AscendingOrderTheft(Vault vault) {
        this.vault = vault;
        this.name = "Ascending Theft";
    }

    @Override
    public void run() {
        IntStream.range(0, 10000)
                 .forEach(i -> {
                     if (this.vault.isPasswordCorrect(i)) {
                         System.out.println(this.name + " has guessed correct password");
                         System.exit(1);
                     }

                     try {
                         Thread.sleep(Constant.CRACK_DURATION);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 });
    }
}

class DescendingOrderTheft implements Runnable {

    private Vault vault;
    private String name;

    public DescendingOrderTheft(Vault vault) {
        this.vault = vault;
        this.name = "Descending Theft";
    }

    @Override
    public void run() {
        for (int i = 9999; i > -1; i--) {
            if (this.vault.isPasswordCorrect(i)) {
                System.out.println(this.name + " has guessed correct password");
                System.exit(1);
            }
            try {
                Thread.sleep(Constant.CRACK_DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class PoliceThread implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("Timing remaining: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Game over!");
        System.exit(1);
    }
}