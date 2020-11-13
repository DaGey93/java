import java.io.*;
import java.net.*;

public class ConsoleClient {

	private BufferedReader tastaturReader = new BufferedReader(new InputStreamReader(System.in));

	private PrintWriter consoleWriter;
	private BufferedReader serverReader;
	private PrintWriter serverWriter;

	private Listener listener = null;

	public void run() {
		String server = null;
		int port = -1;
		Socket socket = null;

		while (true) {
			try {
				System.out.print("Server > ");
				server = tastaturReader.readLine();

				System.out.print("Port > ");
				port = Integer.parseInt(tastaturReader.readLine());

				System.out.println();
			} catch (Exception ex) {
				System.out.println("Falsche Eingabe!");
				continue;
			}

			try {
				socket = new Socket(server, port);
				break;
			} 
			catch (Exception ex) 
			{
				System.out.println("Socket konnte nicht geöffnet werden!");
			}

		}

		System.out.print("Verbunden mit Socket \n");

		try {
			consoleWriter = new PrintWriter(new OutputStreamWriter(System.out));
			serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			serverWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			listener = new Listener(serverReader, consoleWriter);
			listener.start();

			String eingabe;
			
			while ((eingabe = tastaturReader.readLine()) != null) 
			{
				serverWriter.println(eingabe);
				serverWriter.flush();
			}
		} 
		catch (IOException ex) 
		{
			System.out.println("Server Problem!");
		}
	}

	public static void main(String[] args) {

		ConsoleClient client = new ConsoleClient();
		client.run();

	}

}
