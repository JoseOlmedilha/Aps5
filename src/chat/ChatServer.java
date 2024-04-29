package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) throws Exception {
		System.out.println("Aguardando novo usuario...");
		ServerSocket ss = new ServerSocket(9086);
		
		while (true) { //loop para conectar usuarios ao server
			Socket usuario = ss.accept();
			System.out.println("Usuário conectado");
			
			ManipuladorConversa conversa = new ManipuladorConversa(usuario); 
			conversa.start();
		}

	}

}

class ManipuladorConversa extends Thread{
	
	Socket usuarioConversa;
	BufferedReader entrada;
	PrintWriter saida;
	
	public ManipuladorConversa(Socket usuarioConversa) throws IOException{
		this.usuarioConversa = usuarioConversa;
	}
	
	
	public void run() {
		try {
			
			entrada = new BufferedReader(new InputStreamReader(usuarioConversa.getInputStream()));
			saida = new PrintWriter(usuarioConversa.getOutputStream());
			
		}catch(Exception e) {
			
			
		}	
	}
	

}
