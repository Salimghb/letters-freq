package perso.salim.lettersfreqwar.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import perso.salim.lettersfreqwar.ctrl.ControllerInterface;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class LettersFreqWarApplication {

    @Autowired
    @Qualifier("Controller")
    private ControllerInterface controller;

    public static void main(String[] args) {
        SpringApplication.run(LettersFreqWarApplication.class, args);
    }

    @GetMapping("/totOccByLetter")
    public Map<Character, Integer> totOccByLetter(@PathParam(value="language") String language) throws IOException {
        return controller.getTotOccByLetter(language);
    }

    @GetMapping("/posByLetter")
    public Map<Character, int[]> posByLetter(@PathParam(value="language") String language) throws IOException {
        return controller.getPosByLetter(language);
    }

}
