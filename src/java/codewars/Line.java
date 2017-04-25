package codewars;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Line {

    private static final int ticketPrice = 25;
    private static final ArrayList<Integer> COULD_NOT_GIVE_CHANGE = null;
    private static final Logger LOGGER = Logger.getLogger("Line");

    public static String Tickets(int[] peopleInLine)
    {
        List<Integer> change = new ArrayList<>();
        int peopleHandled = 0;
        int note = peopleInLine[0];
        //first in line has to have the exact amount
        if (note != ticketPrice) {
            LOGGER.info("First user did not have exact amount");
            return "NO";
        } else {
            change.add(peopleInLine[peopleHandled]);
            peopleHandled++;
        }

        while (peopleHandled < peopleInLine.length) {
            note = peopleInLine[peopleHandled];
            change.add(note);
            if (note != ticketPrice) {
                change = giveChange(note, change);
                if (change != COULD_NOT_GIVE_CHANGE) {
                    peopleHandled++;
                } else {
                    LOGGER.info("Could not give change for " + note + " with " + change);
                    break;
                }
            } else {
                peopleHandled++;
            }
        }
        return (peopleHandled == peopleInLine.length)? "YES" : "NO";
    }
    private static List<Integer> giveChange(int note, List<Integer> change) {
        //at this stage the note can only be 50 or 100
        LOGGER.info("Trying to give change for " + note + " with " + change);
        if (note == 2 * ticketPrice) {
            OptionalInt changeIndex = findChange(ticketPrice, change);
            if (changeIndex.isPresent()) {
                change.remove(changeIndex.getAsInt());
            } else {
                change = COULD_NOT_GIVE_CHANGE;
            }
            //it is a 100
        } else {
            OptionalInt changeIndex = findChange(2 * ticketPrice, change);
            if (changeIndex.isPresent()) {
                change.remove(changeIndex.getAsInt());
                change = giveChange(50, change);
            } else {
                changeIndex = findChange(25,change);
                if (changeIndex.isPresent()) {
                    change.remove(changeIndex.getAsInt());
                    change = giveChange(25, change);
                } else {
                    change = COULD_NOT_GIVE_CHANGE;
                }
            }
        }
        LOGGER.info("All good " + note + " with " + change);
        return change;
    }

    private static OptionalInt findChange(int noteToFind, List<Integer> change) {
        return IntStream.range(0, change.size())
                .filter(index -> change.get(index) == noteToFind)
                .findFirst();
    }
}