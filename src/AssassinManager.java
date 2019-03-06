import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AssassinManager {
    private static LinkedList<Assassin> players = new LinkedList<>();
    private static final List<String> weapons = Arrays.asList(
            "Candlestick", "Revolver", "Knife", "Lead Pipe", "Rope", "Wrench");

    AssassinManager(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        while(input.hasNextLine()) {
            Node<Assassin> assassin = new Node<>(new Assassin());
            assassin.data.setName(input.next());
            assassin.data.setSkillLevel(input.nextInt());
            players.add(assassin);
        }
    }

    Node<Assassin> getNextVictim() {
        Node<Assassin> node = players.first;
        while(true) {
            if(node.next == null) {
                Node<Assassin> nodeFirst = players.first;
                if(node.data.getSkillLevel() >= nodeFirst.data.getSkillLevel())
                    return nodeFirst;
            } else if(node.data.getSkillLevel() >= node.next.data.getSkillLevel()) {
                return node.next;
            }
            node = node.next;
        }
    }

    void play() {
        printKillRing();
        while(players.first != null && players.first.next != null) {
            Node<Assassin> victim = getNextVictim();
            Node<Assassin> node = players.first;
            if(node != victim) {
                while (node.next != victim) {
                    node = node.next;
                }
            } else {
                while(node.next != null) {
                    node = node.next;
                }
            }
            players.remove(victim);
            System.out.println(deathRecap(node, victim));
        }
        System.out.print("The winner is: ");
        players.print();
    }

    String deathRecap(Node<Assassin> killer, Node<Assassin> victim) {
        String weapon = weapons.get(new Random().nextInt(weapons.size()));
        return "<" + killer.data.toString() + "> killed <" + victim.data.toString() + "> with a " + weapon;
    }

    void printKillRing() {
        Node<Assassin> node = players.first;
        System.out.print("Kill Ring: ");
        System.out.print(node.data.toString());
        node = node.next;
        while(node != null) {
            System.out.print(" > " + node.data.toString());
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        AssassinManager assassinManager = new AssassinManager("C:\\Users\\erica\\IdeaProjects\\Assassin\\src\\players");

        assassinManager.play();
    }
}
