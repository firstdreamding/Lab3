import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.*;

public class WebScraper {

    public static void main(String[] args) {
        String test = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(test);
        System.out.println(wordsInStringArray(test).length + " Words in web page");
        System.out.println(wordsRepeat(test, "prince"));
        System.out.println(wordsSpecial(test));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();

        return contents;
    }

    /**
     * Returns the amount of words in a String, determined by the whitespace.
     * @param string input string
     */
    public static String[] wordsInStringArray(final String string) {
        return string.split("\\s+");
    }

    public static int wordsRepeat(final String words, final String repeat) {
        String[] wordsInString = wordsInStringArray(words);
        int ticker = 0;

        for(int i = 0; i < wordsInString.length; i++) {
            if (wordsInString[i].toLowerCase().equals(repeat)) {
                ticker++;
            }
        }
        return ticker;
    }

    public static int wordsSpecial(final String words) {
        String[] wordsInString = wordsInStringArray(words);
        Set<String> mySet = new HashSet<String>(Arrays.asList(wordsInString));
        return mySet.size();
    }

}
