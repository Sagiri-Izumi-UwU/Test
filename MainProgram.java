import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        //scanner that does nothing of value just like u to society
        Scanner scnr = new Scanner(System.in);

        //create a genshin account
        //WISHING RULES
        /* TO WISH YOU FIRST MUST CREATE AN OBJECT AND MUST ADD AN ARGUMENT FOR USERNAME AND NUMBER OF WISHES
         * .whale(int) just adds wishes lolololol
         * chances of 5 star should be the same as wishing in the real genshin banner
         * idk the chances of 4 star so 15% every wish :skull: then 100% if u dont get a 4 star in 9-10 wishes
         * chances are the drop rates are scuffed but then again this is a prototype that i made in 30 mins instead
         * of doing schoolwork that matters
         * to wish just do .singlePull() or .tenPull()
         */
        XiaoBanner firstAccount = new XiaoBanner("ilovediluc", 0);
        
        System.out.println("Type 1 to do a single pull. 2 to do a 10 pull. 3 to whale and anything else to exit simulator");
        int userInt = scnr.nextInt();
        while(userInt <= 3) {
            if (userInt == 1) {
                firstAccount.singlePull();
            }
            else if (userInt == 2) {
                firstAccount.tenPull();
            }
            else if (userInt == 3) {
                System.out.print("Using the mom's credit card. How many wishes would you like to whale? >>> ");
                int whaling = scnr.nextInt();
                System.out.println();
                firstAccount.whale(whaling);
                System.out.println("Succesfully whaled " + whaling + " wishes.");
                System.out.println();
            }
            userInt = scnr.nextInt();
        }
        scnr.close();

    }
}