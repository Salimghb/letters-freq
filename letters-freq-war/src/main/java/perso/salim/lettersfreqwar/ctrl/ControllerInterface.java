package perso.salim.lettersfreqwar.ctrl;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The interface ControllerInterface.
 */
@Component
public interface ControllerInterface {

    /**
     * Gets tot occ by letter.
     *
     * @param languageCode the code
     * @return the tot occ by letter
     */
    Map<Character, Integer> getTotOccByLetter(String languageCode) throws IOException;

    /**
     * Gets pos by letter.
     *
     * @param languageCode the code
     * @return the pos by letter
     */
    Map<Character, int[]> getPosByLetter(String languageCode) throws IOException;
}
