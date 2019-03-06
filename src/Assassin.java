public class Assassin {
    private String name;
    private int skillLevel;

    public String toString() {
        return name + " (" + skillLevel + ")";
    }

    Assassin() {
        name = null;
        skillLevel = 0;
    }

    public String getName() {
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}
