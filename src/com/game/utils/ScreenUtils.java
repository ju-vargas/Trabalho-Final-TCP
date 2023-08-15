package src.com.game.utils;

public class ScreenUtils {
    
    public void irDePara(javax.swing.JFrame desse, javax.swing.JFrame esse){
        /*
            FUNÇÃO QUE LEVA DA TELA QUE TU ESTÁ PARA A TELA QUE QUER IR, INDO DESSE (PRIMEIRA TELA) PARA ESSE (SEGUNDA TELA)
        */        
        esse.setBounds(desse.getX(), desse.getY(), desse.getWidth(), desse.getHeight());
        esse.setExtendedState(desse.getExtendedState());
        esse.setVisible(true);
        desse.setVisible(false);

    }
}


