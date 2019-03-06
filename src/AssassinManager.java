//Eric Anthony1
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssassinManager {
    private LinkedList<Assassin> players = new LinkedList<>();

    AssassinManager(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        while(input.hasNextLine()) {
            Node<Assassin> assassin = new Node<>(new Assassin());
            assassin.data.setName(input.next());
            assassin.data.setSkillLevel(input.nextInt());
            players.add(assassin);
        }
    }

//    Node<Assassin> getNextVictim() {
//
//    }
//
//    void play() {
//
//    }
//
//    String deathRecap() {
//
//    }


    public static void main(String[] args) throws FileNotFoundException {
        AssassinManager assassinManager = new AssassinManager("C:\\Users\\erica\\IdeaProjects\\Assassin\\src\\players");
        players.print();
    }
}
