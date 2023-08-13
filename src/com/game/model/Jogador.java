package src.com.game.model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Jogador implements Serializable {

	private int tamanho;
	private int[] posicao;
	private int pontuacao;
	private String nome = "Cláudio";
	private int velocidade;

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public Jogador(){
	}
	

	public void mover() {

	}

	public void aumentarPontuacao() {

	}

	public void aumentarTamanho() {

	}

	public void aumetarVelocidade() {

	}

	/*private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(nome);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        nome = in.readUTF();
    }*/
}
