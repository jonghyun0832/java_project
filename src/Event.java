public class Event {

    private String name;
    private int reward;
    private int energy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Event(String name, int reward, int energy) {
        this.name = name;
        this.reward = reward;
        this.energy = energy;
    }


}
