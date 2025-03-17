/*Create a class named SentenceDriver that demonstrates
the use of the Sentence class by presenting a menu that
allows a user to do the following options and implements
each of these features.
 	(1) Enter a sentence
 	(2) Shuffle the sentence
 	(3) Display the original sentence
 	(4) Display the sentence table contents
 	(5) Exit the program
 	Enter a menu option (0 for menu):

An example of a valid input sentence would be
“The large bear slowly chases a fox”.  Note that the driver
program shall only instantiate a Sentence object when a user
chooses the ‘1’ option to enter a sentence.  The ‘2’, ‘3’, and ‘4’
options shall display an error message if no sentence has been
entered yet.
*/
import java.util.Scanner;
public class SentenceDriver
{
    public static void main (String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        Sentence sentence = null;
        int choice;

        displayMenu();

        while (true) 
        {
            System.out.print("Enter Menu Option: ");

            while (!scanner.hasNextInt()) 
            {
                System.out.println("Invalid Menu Option");
                scanner.nextLine();
            }// end while scanner
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 0:
                    displayMenu();
                    break;
                case 1:
                    System.out.print("Enter Sentence(input requires 7 words): ");
                    String input = scanner.nextLine();
                    String[] words = input.split(" ");

                    if (words.length == 7)
                    {
                        sentence = new Sentence(input);
                        System.out.println("Sentence Stored: ");
                    }// end if
                    else
                    {
                        System.out.println("Invalid Sentence");
                    }// end else

                    break;
                case 2:
                    if ( sentence == null) 
                    {
                        System.out.println("No input entered: ");
                    }// end if
                    else 
                    {
                        sentence.shuffle();
                        System.out.println("Sentence Shuffled: ");
                    }// end else 
                    break;
                case 3:
                    if ( sentence == null) 
                    {
                        System.out.println("No input entered: ");
                    }// end if
                    else
                    {
                        System.out.println("Original Sentence: " + sentence);
                    }// end else
                    break;
                case 4:
                    if ( sentence == null)
                    {
                        System.out.println("No input entered: ");
                    }// end if
                    else
                    {
                        System.out.println("Sentence Table Contents: " + sentence.getClass());
                    }// end else
                    break;
                case 5:
                    System.out.println("Exiting Program");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Menu Option: enter a number between 0 and 5 ");
            }// end switch
        }// end while
    }// end main

    private static void displayMenu()
    {
        System.out.println("Menu");
        System.out.println("1 - Enter a Sentence");
        System.out.println("2 - Shuffle");
        System.out.println("3 - Display Original Sentence");
        System.out.println("4 - Display Sentence Table Contents");
        System.out.println("5 - Exit");
        System.out.print("0 - Display Menu Options again ");
    }// end display menu
}// end class
