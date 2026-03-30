package part1.logging;

import java.time.Instant;


public interface Logger {
//Any class that implements logger must provide a "log" method
//This interface allows me to treat ConsoleLogger and LoudLogger as the same "type"

    void log(String message, LogLevel level); //abstract method implemented different for each logger

    default String formatMessage(String message, LogLevel level) { //default that is inherited for all loggers.
        return Instant.now() + " [" + level + "] " + message;
    }
}