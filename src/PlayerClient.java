import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayerClient {
    public static void main(String[] args) throws IOException {
        //Generate Connection between server and clients
        try (
                Socket player = new Socket("localhost", 7000);
                PrintWriter out = new PrintWriter(player.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(player.getInputStream()));
                BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        ){
            System.out.println(in.readLine());
            //Get user input for player name
            String userInput;
            while (true){
                System.out.println("Enter Name: ");
                userInput = userIn.readLine();
                if (!userInput.matches("[A-Za-z]{4,10}")) {
                    System.out.println("Must be between 4 and 10 letters");
                    continue;
                }else break;
            }
            out.println(userInput);
            //print out player hand
            System.out.println("Your Hand is: ");
            System.out.println(in.readLine());

            //print out outcomes and winners of each round
            System.out.println("\nGame Started");
            for (int i=0; i <= 155; i++) {
                System.out.println(in.readLine());
            }
        }
    }

    }

