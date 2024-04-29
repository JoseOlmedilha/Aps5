package chat;

import javax.swing.*;
import java.awt.FlowLayout;

public class ChatClient {
	
	static JFrame chatJanela = new JFrame("Meu Chat");
	static JTextArea chatMensagens = new JTextArea(22, 40);
	static JTextField chatNovaMensagem = new JTextField(40);
	static JButton chatBotaoEnviar = new JButton("Enviar");
	
	public ChatClient() {
		chatJanela.setLayout(new FlowLayout());
		chatJanela.add(new JScrollPane(chatMensagens));
		chatJanela.add(chatNovaMensagem);
		chatJanela.add(chatBotaoEnviar);
		
		chatJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatJanela.setSize(475, 500);
		chatJanela.setVisible(true);
		chatMensagens.setEditable(false);
		chatNovaMensagem.setEditable(false);
		
	}

	public static void main(String[] args) throws Exception {
		ChatClient chat = new ChatClient();
		
	}

}
