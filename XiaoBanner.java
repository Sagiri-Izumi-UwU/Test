import java.util.Random;
public class XiaoBanner {
    Random randGen = new Random();
    String userName;
    int numWishes;
    int pity = 0;
    int fourstarpity = 0;
    int bruh = 6; //this variable does something useful trust me xdd just check private wish method for the "over 73 pity" if statement
    boolean guaranteed = false;
    boolean fourstarguaranteed = false;

    public XiaoBanner(String x, int y) {
        userName = x;
        numWishes = y;
    }

    public void whale(int x) {
        numWishes += x;
    }

    public void singlePull() {
        String item = wishMethod();
        System.out.println(userName + "'s single pull results:");
        System.out.println();
        System.out.println(item);
        System.out.println();
        System.out.println("Pity: " + pity + " Guaranteed: " + guaranteed);
        System.out.println("Wishes left: " + numWishes);
        System.out.println("---------------------");
        System.out.println();
    }

    public void tenPull() {
      System.out.println(userName + "'s ten pull results:");
      System.out.println();
      String item;
      for (int i = 0; i < 10; i++) {
          item = wishMethod();
          System.out.println(item);
      }
      System.out.println();
      System.out.println("Pity: " + pity + " Guaranteed: " + guaranteed);
      System.out.println("Wishes left: " + numWishes);
      System.out.println("---------------------");
      System.out.println();
    }
    

    // this method determines if item will be a 3, 4 or 5 star
    private String wishMethod() {
        int randomNumber;
        String item;

        //this checks if you actually have the wishes to gamble. Does not fully work so make sure u make 999 wishes.
        //if numWishes greater then 1 then:
        if (numWishes > 0) {
           //if hard pity 
           if (pity == 90) {
              item = fivestarItem();
           }
           //if 4 star hard pity
           else if (fourstarpity >= 9) {
           item = fourstarItem();
           }
           //if pity is 73 above
           //what "bruh" variable does is basically the chance of you getting a 5 star that increases by 6% for every wish
           else if (pity > 72) {
              //generates a random number between 1-1000 that determines the rarity. Bruh is 6 because 6/1000 is 0.6%
              randomNumber = randGen.nextInt(1000) + 1;
              if (randomNumber <= bruh) {
                 item = fivestarItem();
                 bruh = 6;
              }
              //you get a 4 star if randomNumber generates a number higher than "bruh" but under 150 + bruh
              //150 because in this code idfk the chances of getting a 4 star so its 15% per pull then 100% if u dont get a 4 star after 9-10 pulls
              else if (randomNumber > bruh && randomNumber <= bruh + 150) {
                 item = fourstarItem();
                 //adds 60 to bruh which increases chance by 6%
                 bruh += 60;
              }
              //anything else is a 3 star
              else {
                 item = threestarItem();
                 bruh += 60;
              }
           }
           //when pity is below 73
           else {
              //generates a number between 1-1000. Getting 1-6 equals a 5 star. 7 - 156 is a 4 star and anything else is a 3 star.
              randomNumber = randGen.nextInt(1000) + 1;
              if (randomNumber <= 6) {
                 item = fivestarItem();
              }
              else if (randomNumber <= 156) {
                 item = fourstarItem();
              }
              else {
                 item = threestarItem();
              }
           }
        }
        else {
           item = "You have no wishes idiot";
        }
        numWishes -= 1;  
        return item;
    }

    private String fivestarItem() {
        int randomNum = randGen.nextInt(2);
        String fivestar;
        if (guaranteed == true) {
            fivestar = "Xiao";
            guaranteed = false;
        }
        else {
           if (randomNum == 0) {
               fivestar = "Xiao";
               guaranteed = false;
           }
           else {
               fivestar = "Qiqi";
               guaranteed = true;
           }
        }
        //resets pity to 0
        pity = 0;
        fourstarpity += 1;
        fivestar = fivestar + "(FIVE STAR! *****)";
        return fivestar;
    }

    private String fourstarItem() {
        int randomNum;
        String fourstar;

        if (fourstarguaranteed == true) {
           randomNum = randGen.nextInt(3);
           switch (randomNum) {
              case 0:
                 fourstar = "Bennett";
                 break;
              case 1:
                 fourstar = "Faruzan";
                 break;
              case 2:
                 fourstar = "Xingqui";
                 break;
              default:
                 fourstar = "nERROR";
           }
           fourstarguaranteed = false;
        }
        else {
            //if 4 star is not guaranteed
            randomNum = randGen.nextInt(7);
            switch (randomNum) {
                case 0:
                   fourstar = "Bennett";
                   break;
                case 1:
                   fourstar = "Faruzan";
                   break;
                case 2:
                   fourstar = "Xingqui";
                   break;
                case 3:
                   fourstar = "Noelle";
                   fourstarguaranteed = true;
                   break;
                case 4:
                   fourstar = "Diona";
                   fourstarguaranteed = true;
                   break;
                case 5:
                   fourstar = "Sacrificial Sword";
                   fourstarguaranteed = true;
                   break;
                case 6: 
                   fourstar = "The Flute";
                   fourstarguaranteed = true;
                   break;
                default:
                   fourstar = "wERROR";
             }
        }
        pity += 1;
        fourstarpity = 0;
        fourstar = fourstar + " (Four star ****)";
        return fourstar;
    }

    private String threestarItem() {
        int randomNum = randGen.nextInt(15);
        String threestar;
        switch (randomNum) {
           case 0:
              threestar = "Skyrider Sword";
              break;
           case 1:
              threestar = "Harbinger of Dawn";
              break;
           case 2:
              threestar = "Cool Steel";
              break;
           case 3:
              threestar = "Thrilling Tales of Dragonslayer";
              break;
           case 4:
              threestar = "Magic Guide";
              break;
           case 5:
              threestar = "Recurve Bow";
              break;
           case 6: 
              threestar = "Slingshot";
              break;
           case 7:
              threestar = "Sharpshooter's Oath";
              break;
           case 8:
              threestar = "Black Tassle";
              break;
           case 9:
              threestar = "Skyrider Sword";
              break;
           case 10: 
              threestar = "Bloodstained Greatsword";
              break;
           case 11: 
              threestar = "Raven Bow";
              break;
           case 12:
              threestar = "Debate Club";
              break;
           case 13: 
              threestar = "Ferrous Shadow";
              break;
           case 14:
              threestar = "Emerald Orb";
              break;
           default:
              threestar = "ERROR";
        }
        pity += 1;
        fourstarpity += 1;
        return threestar;
    }

}