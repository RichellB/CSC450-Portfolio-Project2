public class PortfolioProject2 {
    public static void main(String[] args) {
        
        // Creating the first thread to count up to 20
        Thread countUpThread = new Thread(new CountUpRunnable());
        countUpThread.start(); // Starting the count-up thread

        try {
            // Waiting for the count-up thread to finish
            countUpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handling possible interruptions
        }

        // Creating the second thread to count down from 20
        Thread countDownThread = new Thread(new CountDownRunnable());
        countDownThread.start(); // Starting the count-down thread
    }
}

// Count up class
class CountUpRunnable implements Runnable {
    @Override
    public void run() {

        // Loop to count up from 0 to 20
        for (int i = 0; i <= 20; i++) {
            System.out.println("Count Up: " + i); // Printing the current count
            try {
                Thread.sleep(100); // Sleep to allow context switching
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handling interruptions during sleep
            }
        }
    }
}

// Count down class
class CountDownRunnable implements Runnable {
    @Override
    public void run() {

        // Loop to count down from 20 to 0
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i); // Printing the current count
            try {
                Thread.sleep(100); // Sleep to allow context switching
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handling interruptions during sleep
            }
        }
    }
}
