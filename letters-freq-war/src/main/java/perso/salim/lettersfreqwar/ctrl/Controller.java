package perso.salim.lettersfreqwar.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import perso.salim.lettersfreqwar.utils.FileUtils;

import java.io.IOException;
import java.util.*;

@Component("Controller")
public class Controller implements ControllerInterface {

    @Autowired
    private FileUtils fileUtils;

    final static private int SIZE_PERCENTAGE = 10;

    /**
     * Gets tot occ by letter.
     *
     * @param languageCode the code
     * @return the tot occ by letter
     */
    @Override
    public Map<Character, Integer> getTotOccByLetter(String languageCode) throws IOException {

        String path = fileUtils.getPathFromCode(languageCode);
        List<String> dictionary = fileUtils.getDictionnary(path);

        Map<Character, Integer> totOccByLetter = new TreeMap<>();

        dictionary.stream().flatMap(word -> Arrays.stream(convertStringToCharList(word))).forEach(character ->
                // If absent put (1). If present put (old + 1)
                totOccByLetter.merge(character, 1, Integer::sum)
        );

        return totOccByLetter;
    }

    // Function to convert String to List of Characters
    private Character[] convertStringToCharList(String str){

        return str
                // Convert to String to IntStream
                .chars()
                // Convert IntStream to Stream<Character>
                .mapToObj(ascii -> (char) ascii).toArray(Character[]::new);

    }

    /**
     * Gets pos by letter.
     *
     * @param languageCode the code
     * @return the pos by letter
     */
    @Override
    public Map<Character, int[]> getPosByLetter(String languageCode) throws IOException {

        String path = fileUtils.getPathFromCode(languageCode);
        List<String> dictionary = fileUtils.getDictionnary(path);

        Map<Character, int[]> posByLetter = new TreeMap<>();

        Map<Character, int[]> posByLetterEachWord;

        for (String word : dictionary) {

            posByLetterEachWord = convertStringToPos(word);

            for(Map.Entry<Character, int[]> entry : posByLetterEachWord.entrySet()){
              //  posByLetter.merge(entry.getKey(), entry.getValue(), this::add);
                if(posByLetter.get(entry.getKey()) != null){
                    posByLetter.put(entry.getKey(), this.add(entry.getValue(), posByLetter.get(entry.getKey())));
                }else{
                    posByLetter.put(entry.getKey(), entry.getValue());
                }
            }

        }

        return posByLetter;
    }

    private Map<Character, int[]> convertStringToPos(String word){
        Map<Character, int[]> posMapByChar = new HashMap<>();
        Set<Character> setChar = new HashSet<>(Arrays.asList(convertStringToCharList(word)));

        setChar.forEach(character -> posMapByChar.put(character, getIndexOn10FromLetterAndWord(character, word)));

        return posMapByChar;
    }

    private int[] getIndexOn10FromLetterAndWord(Character character, String word){
        int wordSize = word.length();

        int[] indexsOn10 = new int[SIZE_PERCENTAGE];
        int pos;

        for (int i = 0; i < wordSize; i++) {
            if(character.equals(word.charAt(i))){
                pos = i * 10 / wordSize;
                indexsOn10[pos] = indexsOn10[pos] + 1;
            }
        }

        return indexsOn10;
    }

    /**
     * Adds numbers of two arrays. if arrays are of Different length than only
     * addition only occur for as many elements in the small array.
     *
     * @param first array
     * @param second array
     * @return sum of first and second
     */
    private int[] add(int[] first, int[] second) {
        int length = Math.min(first.length, second.length);

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = first[i] + second[i];
        }

        return result;
    }

}
