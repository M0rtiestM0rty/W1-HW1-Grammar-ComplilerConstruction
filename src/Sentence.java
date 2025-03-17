/*1.	Create a class named Sentence.
In the Sentence class, declare the following seven
private attributes of type String:
    subjectMarker
 	adjective
 	subject
 	adverb
 	verb
 	directObjectMarker
 	directObject
2.	Also declare a private array named sentenceTable
containing seven String elements with the indexes of
the array having the following designations:
 	0 – subject marker
 	1 – adjective
 	2 – subject
 	3 – adverb
 	4 – verb
 	5 – direct object marker
 	6 – direct object
3.	Create a constructor for the Sentence class.
 	The constructor takes one parameter, a character string.
 	It calls the parse() method and passes the character string
 	to it.
4.	In the Sentence class, create the public methods described
    below.he parse() method takes a character string as a parameter and
    returns void.  It parses the words in the character string into the
    respective seven private attributes of the Sentence class.  It
    assumes that the contents of the string parameter are correctly
    formatted.No standard Java API methods are used to parse the string.
    Instead, just basic Java coding for reading a character and
    building a character string is used to perform the parsing
    algorithm.The toString() method takes no parameters.  It uses
    the contents of the seven Sentence attributes to create a
    string with a single space between each attribute.  The order
    of the attributes is subject marker, adjective, subject, adverb,
    verb, direct object marker, and direct object.  It then returns
    the string.The shuffle() method takes no parameters and returns
    void.  It first loads the contents of the seven Sentence
    attributes into the sentenceTable array, and does so in their
    original order. It then uses a random number generator to shuffle
    the contents of the elements in the sentenceTable.The
    getSentenceTableContents() method takes no parameters.
    It uses the contents of the sentenceTable to create a string
    with a single space between each element.  In the string, the
    elements should be placed in order from 0 to 6.  It then returns
    the string.

*/
import java.util.Random;
public class Sentence
{
    private String subjectMarker;
    private String adjective;
    private String subject;
    private String adverb;
    private String verb;
    private String directObjectMarker;
    private String directObject;
    // attributes
    private String [] sentenceTable;
    // array

    public Sentence(String input)
    {
        sentenceTable = new String[7];
        parse(input);
    }// end Constructor

    private void parse (String input)
    {
        int index = 0, wordIndex = 0;
        char [] chars = input.toCharArray();
        StringBuilder word = new StringBuilder();

        while (index < chars.length && wordIndex < 7)
        {
            char c = chars[index];

            if (c == ' ')
            {
                if (word.length() > 0)
                {
                    assignWord (word.toString(), wordIndex);
                    wordIndex++;
                    word.setLength(0);
                    // space for nest word
                }// end nested if loop
            }// end outer if loop
            else
            {
                word.append(c);
            }// end

            index++;
        }// end while loop
        if (word.length() > 0 && wordIndex < 7)
        {
            assignWord(word.toString(), wordIndex);
        }// end if
    }// end private parse method

    private void assignWord (String word, int index)
    {
        switch (index)
        {
            case 0:
                subjectMarker = word;
                break;
            case 1:
                adjective = word;
                break;
            case 2:
                subject = word;
                break;
            case 3:
                adverb = word;
                break;
            case 4:
                verb = word;
                break;
            case 5:
                directObjectMarker = word;
                break;
            case 6:
                directObject = word;
                break;
            default:
                throw new IllegalArgumentException("Invalid index" + index);
        }// end switch
    }// end assignWord Method

    //sentence back to string
    public String toString()
    {
        return String.join(" ", subjectMarker,
                adjective,subject,adverb,verb, directObjectMarker,
                directObject);
    }// end toString method

    public void shuffle()
    {
        sentenceTable = new String[] {subjectMarker, adjective,
                subject, adverb, verb, directObjectMarker,};

        Random rand = new Random();
        for(int a = sentenceTable.length - 1; a >= 0; a--)
        {
            int b = rand.nextInt(a + 1);
            String temp = sentenceTable[b];
            sentenceTable[a] = sentenceTable[b];
            sentenceTable[b] = temp;
        }// end for loop
    }// end shuffle method

    public static void main (String[] args)
    {
        Sentence sentence = new Sentence("The quick brown fox jumps over the lazy dog");

        System.out.println("Original Sentence" + sentence);
        sentence.shuffle();
        System.out.println("Shuffled Sentence" + sentence);
    }// end main
}// end Class
