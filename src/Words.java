import java.util.ArrayList;
import java.util.Random;

public class Words {

    private static ArrayList<String> words = new ArrayList<>();

    private static final Random RANDOM = new Random();

    public static String generateWord (){
        return words.get(RANDOM.nextInt(words.size()));
    }

    //Arraylist of words
    static {
        words.add("google");
        words.add("coding");
        words.add("computer");
        words.add("pies");
        words.add("football");
        words.add("milkshake");
        words.add("playstation");
        words.add("horizon");
        words.add("reading");
        words.add("movie");
        words.add("bottle");
        words.add("alcohol");
        words.add("family");
        words.add("master");


    }



}
