package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class Animal extends InputParameters {
    private Vector2d positionOnTheMap;
    private MapDirections orientation;
    private int timeLeftToDeath;
    private DNA genotype;
    private int numberOfKids;
    private int numberOfDescendants;
    private int dayOfDeath;
    Random random = new Random();

    // dodac jeszcze zwiaezraki po smierci i narodzniach ale to jak bedzie mapa,
    // dodac ruch do przodu jak ogarne mape
    // rozmnazanie dodac
    // dodac sobie to ze adam i ewa nie moga pojawic sie na tym samym polu



    public Animal() {       // tworzenie adama i ewy
        int x; int y;
        x = random.nextInt(getWidth());
        y = random.nextInt(getHeight());
        this.positionOnTheMap = new Vector2d(x, y);
        this.orientation = MapDirections.getRandom();
        this.timeLeftToDeath = getInitialEnergy();
        this.genotype = new DNA();
        this.numberOfKids = 0;
        this.numberOfDescendants = 0;
    }

    public Animal(Animal firstParent, Animal secondParent){     // tworzenie dziecka
        this.positionOnTheMap = new Vector2d(firstParent.positionOnTheMap.x, firstParent.positionOnTheMap.y);
        this.orientation = MapDirections.getRandom();
        this.timeLeftToDeath = getInitialEnergy();
        this.genotype = new DNA(firstParent, secondParent);
        this.numberOfKids = 0;
        this.numberOfDescendants = 0;
    }

    public int getDayOfDeath(){
        return this.dayOfDeath;
    }

    public MapDirections getOrientation(){
        return this.orientation;
    }

    public Vector2d getPositionOnTheMap(){
        return this.positionOnTheMap;
    }

    public int getTimeLeftToDeath(){
        return this.timeLeftToDeath;
    }

    public DNA getGenotype(){
        return this.genotype;
    }

    public void move(int[] genes){
        for (int gene : genes){
            switch (gene) {
                case 0:
                    Vector2d newPosition = this.positionOnTheMap.add(this.orientation.toUnitVector());
                case 1:
                    this.orientation = this.orientation.next();
                    break;
                case 2:
                    this.orientation = this.orientation.next().next();
                    break;
                case 3:
                    this.orientation = this.orientation.next().next().next();
                    break;
                case 4:
                    Vector2d newPositionB = this.positionOnTheMap.subtract(this.orientation.toUnitVector());
                case 5:
                    this.orientation = this.orientation.next().next().next().next().next();
                    break;
                case 6:
                    this.orientation = this.orientation.next().next().next().next().next().next();
                    break;
                case 7:
                    this.orientation = this.orientation.next().next().next().next().next().next().next();
            }
        }
    }

    public void eatingPlant(Plant plant){
        this.timeLeftToDeath = this.timeLeftToDeath + plant.kcal;
    }

    public void isDying(int day){       // dodac martwe zwierzaki
        if (this.timeLeftToDeath <= 0){
            this.death(day);
        }
    }

    public int getNumberOfKids(){
        return this.numberOfKids;
    }

    public int getNumberOfDescendants(){
        return this.numberOfDescendants;
    }

    public void madeNewBaby(){
        this.numberOfKids += 1;
        this.numberOfDescendants += 1;
    }

    public void death(int day){
        this.dayOfDeath = day;
    }

}
