import java.util.Scanner;

class StonePaperScissor {
  public static void main(String[] args) {
    startGame();

  }

  public static void startGame() {
    System.out.println();
    System.out.println("*****WELCOME*****");
    System.out.println();
    String userResponse = userResponse();
    String botResponse = botResponse();
    System.out.println();
    System.out.println("BOT :" + botResponse + "     USER : " + userResponse);
    System.out.println();
    findWinner(userResponse, botResponse);

  }

  public static String userResponse() {
    Scanner sc = new Scanner(System.in);
    System.out.println("1.  STONE");
    System.out.println("1.  PAPER");
    System.out.println("1.  SCISSOR");
    System.out.print(" User Enter Your Option  : ");

    int opt = sc.nextInt();
    if (opt < 0 || opt > 3) {
      System.out.println("Invalid Option Entered");
      System.exit(0);

    }
    String userResponse = generateResponse(opt);
    return userResponse;

  }

  public static String botResponse() {
    int opt = 0;
    for (;;) {
      opt = (int) (Math.random() * 10);
      if (opt > 0 && opt < 4)
        break;

    }
    String botResponse = generateResponse(opt);
    return botResponse;

  }

  public static String generateResponse(int opt) {
    String response = "";
    switch (opt) {
      case 1:
        response = "STONE";
        break;
      case 2:
        response = "PAPER";
        break;
      case 3:
        response = "SCISSOR";
        break;
      default:
        System.out.println("Invalid Option");
        break;

    }
    return response;

  }

  public static void findWinner(String userResponse, String botResponse) {
    if ((userResponse.equals("PAPER") && botResponse.equals("STONE")) ||
        (userResponse.equals("SCISSOR") && botResponse.equals("PAPER")) ||
        (userResponse.equals("STONE") && botResponse.equals("SCISSOR"))) {
      System.out.println("*****USER WON*****");

    } else if ((userResponse.equals("SCISSOR") && botResponse.equals("STONE")) ||
        (userResponse.equals("STONE") && botResponse.equals("PAPER")) ||
        (userResponse.equals("PAPER") && botResponse.equals("SCISSOR"))) {
      System.out.println("*****BOT WON*****");

    }

    else {
      System.out.println("*****DRAW*****");
    }
  }
}
