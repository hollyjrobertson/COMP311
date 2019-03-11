package hw6;

import java.io.BufferedReader;
import java.util.*;

public class Dictionary
{
    Map<String, Integer> frequency = new HashMap<String, Integer>();
    Map<String, HashMap<String, String>> languages = 
            new HashMap<String, HashMap<String, String>>();
    HashMap<String, String> enDictionary;
    HashMap<String, String> spDictionary;
    HashMap<String, String> icDictionary;
    HashMap<String, String> frDictionary;
    
    public Map<String, Integer> addStringToMap(BufferedReader reader) throws Exception {
        String line = reader.readLine();
        
        while(line != null) {
            
            if(!line.trim().equals("")) {
                String [] words = line.replaceAll("[^a-zA-Z ]", "").split(" "); 
            
                for (String word : words) {
                    if (word == null || word.trim().equals("")) {
                        continue;
                        }
                    String processed = word.toLowerCase();
                    
                    if(frequency.containsKey(processed)) {
                        frequency.put(processed, frequency.get(processed) + 1);
                    }
                    else {
                        frequency.put(processed, 1);
                    }
                }
            }
            
            line = reader.readLine();
        }
        return frequency;
    }
    
    public void init() {
        enDictionary = new HashMap<String, String>();
        spDictionary = new HashMap<String, String>();
        icDictionary = new HashMap<String, String>();
        frDictionary = new HashMap<String, String>();
        
        /**
         * Set some words to translate
         */
        enDictionary.put("Hello", "1");
        spDictionary.put("Hola", "1");
        icDictionary.put("Hallo", "1");
        frDictionary.put("Bonjour", "1");
        /*
         * Key is the name of the language
         * The Value would be the full dictionary
         */
        languages.put("English", enDictionary);
        languages.put("Spanish", spDictionary);
        languages.put("Icelandic", icDictionary);
        languages.put("French", frDictionary);
        
    }
    
    public String translateWord(String word, String srcLanguage, 
            String destLanguage) throws Exception {
        
        HashMap<String, String> srcDictionary;
        HashMap<String, String> destDictionary;
        String translatedWord = null;
        
        //Initiatialize Languages
        init();
        
        /**
         * If the srcDictionary equals a language not in the languages dictionary
         * Throw an exception
         */
      
        if ((srcDictionary = languages.get(srcLanguage)) == null) {
            throw new Exception("The language does not belong in the languages map");
        }
        
        if ((destDictionary = languages.get(destLanguage)) == null) {
            throw new Exception("The language does not belong in the languages map");
        }
        
        /**
         * Set word to translate
         */
        String toTranslate = srcDictionary.get(word);
        
        /**
         * Look through the key set in the destination dictionary for the word
         * toTranslate
         * If found, return the value of the key
         */
        for (String str : destDictionary.keySet()) {
            if (toTranslate.equalsIgnoreCase(destDictionary.get(str))) {
                translatedWord = str;
            }
            else {
                translatedWord = str + " cannot be found";
            }
        }
        return translatedWord;
    }   
}

