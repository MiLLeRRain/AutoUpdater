import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class LoginTokenAutoUpdater {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        // Construct the timer
        Timer timer = new Timer();
        System.out.println("Starting from: "+new Date());
        // starting from 3000ms, run every 86400000ms;
        timer.schedule(new MyTask(),3000,86400000);
    }
}

/**
 * Timed Task
 */
class MyTask extends TimerTask{

    // function to be called back
    FirebaseUtil fu = new FirebaseUtil();

    MyTask() throws IOException, ExecutionException, InterruptedException {
    }

    @SneakyThrows
    public void run() {
        System.out.println("Hello. Current time is: "+new Date());
        fu.updateToken();
    }

}