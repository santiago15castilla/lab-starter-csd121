package part1.logging;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MemoryLogger implements Logger, Exportable {

    private final List<String> messages = new ArrayList<>(); //we store the messages in this list instead of printing them.
                                                             //must be Array because we need to add messages one by one
    @Override
    public void log(String message, LogLevel level) { //adding the formating message to the list.
        messages.add(formatMessage(message, level));
    }

    @Override
    public void exportTo(OutputStream out) {
        PrintWriter writer = new PrintWriter(out); //PrintWriter wraps the OutputStream
        for (String message : messages) {          //go through every stored message and write it to the OutputStream.
            writer.println(message);
        }
        writer.flush(); // flush() forces all buffered messages to actually be written out.
    }
}