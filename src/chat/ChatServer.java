package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

	static ArrayList<String> listaUsuarios = new ArrayList<String>();
	static ArrayList<PrintWriter> printWriters = new ArrayList<PrintWriter>();

	public static void main(String[] args) throws Exception {
		System.out.println("Aguardando novo usuario...");
		ServerSocket ss = new ServerSocket(9086);

		while (true) { // loop para conectar usuarios ao server
			Socket usuario = ss.accept();
			System.out.println("Usuário conectado!");

			ManipuladorConversa conversa = new ManipuladorConversa(usuario);
			conversa.start();
		}

	}

}

class ManipuladorConversa extends Thread {

	Socket usuarioConversa;
	BufferedReader entrada;
	PrintWriter saida;
	String nome;

	public ManipuladorConversa(Socket usuarioConversa) throws IOException {
		this.usuarioConversa = usuarioConversa;
	}

	public void run() {
		try {

			entrada = new BufferedReader(new InputStreamReader(usuarioConversa.getInputStream()));
			saida = new PrintWriter(usuarioConversa.getOutputStream(), true);

			int contador = 0;
			while (true) {
				
				if (contador > 0) {
					saida.println("Nome já existente");
				} else {
					saida.println("Nome disponivel");
				}
				
				nome = entrada.readLine();

				if (nome == null) {
					return;
				}

				if (!ChatServer.listaUsuarios.contains(nome)) {
					ChatServer.listaUsuarios.add(nome);
					break;
				}

				contador++;
			}

			saida.println("Nome aceito " + nome);
			ChatServer.printWriters.add(saida);
		
			
			while(true){
				String msg = entrada.readLine();
			
				
				if( msg == null) {
					return;
				}
				
				for(PrintWriter writer : ChatServer.printWriters) {
					writer.println(nome + ": " + msg);
					
				}
			}
			
			

		} catch (Exception e) {
			System.out.println("Erro no servidor " + e.getMessage());
			e.printStackTrace();
		}
	
	
	
	}





}
