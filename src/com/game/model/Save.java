package src.com.game.model;

import java.io.*;
import java.util.ArrayList;
import src.com.game.view.GameScreen;

public class Save implements Serializable {

    private ArrayList<GameScreen> gameScreens;
	private Jogador playerSave;

    public Save() {
        this.gameScreens = new ArrayList<GameScreen>();
		this.playerSave = new Jogador();
    }

    public ArrayList<GameScreen> getGameScreens() {
        return gameScreens;
    }

    public void addGameScreen(GameScreen gameScreen) {
        gameScreens.add(gameScreen);
    }

    public void saveToFile() {
		File arquivo = null;
		ObjectOutputStream obj = null;

        try {
			arquivo = new File("./save.obj");
			obj = new ObjectOutputStream(new FileOutputStream(arquivo, true));
			obj.writeObject(playerSave);
			
			obj.close();
			System.out.println("Jogo salvo com sucesso!");
		}
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jogador loadFromFile() {
        Jogador loadedPlayer = null;
		File arquivo = null;
		ObjectInputStream obj = null;

		try{
			arquivo = new File("./save.obj");
			obj = new ObjectInputStream(new FileInputStream(arquivo));

			loadedPlayer = (Jogador) obj.readObject();
			obj.close();
			System.out.println("Jogo carregado com sucesso!");
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return loadedPlayer;
    }
	
	public static void main(String[] args) {
		//SALVA

		//Save novoSave = new Save(); // Crie uma instância da classe Save
		//novoSave.saveToFile();      // Chame o método saveToFile() nessa instância
	
		//CARREGA

		//Jogador playerCarregado = loadFromFile(); // Chame o método loadFromFile() usando o nome da classe
		//System.out.println("Nome do jogador carregado: " + playerCarregado.getNome());
	}
	

}
