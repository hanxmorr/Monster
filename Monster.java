
/**
 * Description: Monster blueprint
 */

/**
 * @author Horacio Valdes and Hanna Morreale
 *
 *
 */

 // We both worked on this together
public class Monster {
	// Monster health
	private double health ;
	// Monster strength
	private double strength;
	// Monster name
	private String name;
	// Monster speed
	private int speed;

	public Monster() {
		this.health = 0;
		this.strength = 0;
	}
	public Monster(String newName, double newHealth, double newStrength, int newSpeed) {
		this.health = newHealth;
		this.strength = newStrength;
		this.name = newName;
		this.speed = newSpeed;
	}

	//Getters for monster
    public double getHealth() { return this.health; }
    public double getStrength() { return this.strength; }
    public String getName() { return this.name;}
    public int getSpeed() {return this.speed;}



    //Setters for monsters
    public double setHealth(double health) { return this.health = health; }
    public double setStrength(double strength) { return this.strength = strength; }
    public String setName(String name) {return this.name = name;}
    public int setSpeed(int speed) {return this.speed = speed;}

    public double attack() {return  Math.random() * this.strength;}
    public double takeDamage(double damage) {return this.health = this.health - damage;}


    public double getAttackPriority() { return  this.speed * Math.random();}

    //Format monster properties
    public String toString() {return String.format("name: %s, health: %.2f, strength: %.2f, speed: %d", this.name, this.health, this.strength, this.speed);}


    public Boolean isAlive() {
    	if(health>0) {
    		return true;
    	}
    	else
    		return false;

}
}
