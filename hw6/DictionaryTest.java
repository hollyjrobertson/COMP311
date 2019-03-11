package hw6;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest
{

    Dictionary dict;
    BufferedReader reader;
    Path path = Paths.get(System.getProperty("user.dir")).resolve("input.txt");
    String wordToTranslate;
    String srcLanguage;
    String destLanguage;
    
    @Before
    public void setUp() throws Exception {
        reader = new BufferedReader(new FileReader(path.toFile()));
        dict = new Dictionary();
    }

    @After
    public void tearDown() throws Exception {
        dict = null;
        reader = null;
    }

    @Test
    public void testAddStringToMap() throws Exception {
        String answer = "{established=1, readable=1, a=3, fact=1, be=1, will=1, reader=1, its=1, is=1, it=1, distracted=1, when=1, long=1, content=1, the=1, layout=1, that=1, at=1, by=1, of=1, looking=1, page=1}"; 
     
        assertEquals(answer, dict.addStringToMap(reader).toString());
    }
    
    @Test
    public void testTranslateWord() throws Exception {
        String english = "Hello";
        String spanish = "Hola";
        String icelandic = "Hallo";
        String french = "Bonjour";
        
        assertEquals(spanish, dict.translateWord(english, "English", "Spanish"));
        assertEquals(english, dict.translateWord(spanish, "Spanish", "English"));
        assertEquals(english, dict.translateWord(icelandic, "Icelandic", "English"));
        assertEquals(english, dict.translateWord(french, "French", "English"));
    }

}
