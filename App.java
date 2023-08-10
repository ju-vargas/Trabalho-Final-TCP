import src.com.game.model.Fase;

public class App {
    public static void main(String[] args) {

        Fase fase1 = new Fase();
        faseScreen faseScreen = new faseScreen(fase1);

        //faseScreen.showWinScreen();
        //faseScreen.showDeathScreen();
        faseScreen.showIntroductionScreen();

    }
}
