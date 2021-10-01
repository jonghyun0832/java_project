public class Feature {

    private int economy;
    private int religion;
    private int force;
    private int population;

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Feature(int economy, int religion, int force, int population) {
        this.economy = economy;
        this.religion = religion;
        this.force = force;
        this.population = population;
    }

    public  Feature(){

    }

}
