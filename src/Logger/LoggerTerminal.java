package Logger;

import java.time.LocalDateTime;

public class LoggerTerminal implements Loggerable{
    @Override
    public void logg(String msg) {
        System.out.println(msg + LocalDateTime.now());
    }
}
