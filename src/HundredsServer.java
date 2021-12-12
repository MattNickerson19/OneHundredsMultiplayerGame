import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * One Hunderds 4 Player Game
 * @author mattnickerson
 *
 * Rules: Cards are dealt to each of the 4 players. Each hand the players lay their next card and whoever has the highest value card wins the round.
 *        There are 4 wildcards in the game which will beat any regular card.
 *
 * To play the game run the "HundredsServer.java" main method, the server will then wait for 4 players to join the game before beginning.
 * Once the server is running, run the "PlayerClient.java" main method and enter the name of the player.
 * Once 4 clients have been run and the names entered, the game will begin.
 *
 * Each player's hand will be output to them as well as the results of each round and the final scores of the overall game.
 */


public class HundredsServer{
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        PrintWriter out = null;

        //Generate Connection between server and clients
        ServerSocket serverSocket = new ServerSocket(7000);
        System.out.println("Server is running...");
        int i = 4;
        OneHundreds oneHundreds = new OneHundreds();
        while (true){
            System.out.println("Waiting for " + i + " players...");
            Socket clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            ClientHandler clientThread = new ClientHandler(clientSocket);
            clients.add(clientThread);
            clientThread.run();
            i -=1;
            //Add players to game
            oneHundreds.addPlayer(clientThread.getName());

            if (clients.size() == 4){
                break;
            }
        }

        //Deal cards to players
        oneHundreds.dealCards();

        //Output hand to player
        for (ClientHandler client : clients){
            out = client.getOut();
            out.println(oneHundreds.showHand(client.getName()));
        }

        //Print outcome of each hand played and winners
        ArrayList<String> output = oneHundreds.playGame();
        for (ClientHandler client : clients){
            out = client.getOut();
            for (int x = 0; x < output.size(); x++) {
                out.println(output.get(x));
       }}

    }
}
