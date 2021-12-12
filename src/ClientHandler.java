import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public PrintWriter getOut() {
        return out;
    }

    public String getName() {
        return name;
    }

    private String name;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);

    }
    public void setName(){
        out.println("Welcome To One Hundreds!");
        //Get Client Name
        try {
            name = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        setName();
    }
}
