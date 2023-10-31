import controller.WordController;
import model.WordModel;
import view.WordView;

public class Main {
    
    public static void main(String[] args) {
        WordModel model = new WordModel();
        WordView view = new WordView();
        WordController controller = new WordController(model, view);
        controller.processUserInput();
    }
}
