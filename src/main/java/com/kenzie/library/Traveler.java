package com.kenzie.library;

public class Traveler {
//Code Traveler class
    //properties
    protected String name;
    protected int food;
    protected boolean isHealthy;

    //constructor
    public Traveler() {
        this.name = "";
        this.food = 1;
        this.isHealthy = true;
    }
    //constructor
    public Traveler(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getFood() {
        return this.food;
    }

    public boolean getIsHealthy() {
        return this.isHealthy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setIsHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }
    //method hunt() increase travelers food by 2
    public void hunt(){
        this.food= food + 2;
    }

    //method eat() consumes 1 unit of the traveler's food.
    // if traveler has no food to eat traveler is no longer healthy
    public void eat(){
         if(food > 0){
             this.food-=1;
         } else{
             setIsHealthy(false);
         }

    }


}

class Doctor extends Traveler {
//TODO: Code Doctor class
    public Doctor() { super();}
    public Doctor(String name) {super(name);}
    //method heal(Traveler traveler)
    public void heal(Traveler sickTraveler){
        //pass sick traveler method as parameter to .heal() method
        //isHealthy changes to true
        if(!sickTraveler.isHealthy){
        //(sickTraveler.isHealthy == false){
            sickTraveler.isHealthy = true;
        }

    }

}

class Hunter extends Traveler {
//TODO: Code Hunter class
    public Hunter() { super(); this.food = 2;}
    public Hunter(String name) {super(name); }

    //increase hunters food by 5 (normal gains only 2)
    @Override
    public void hunt() {
        super.hunt();
        this.food = food + 3;
    }

    @Override
    public void eat() {
        if(food >= 2) {
            food -= 2;
        }else{
            food=0;
            this.isHealthy = false;
        }
     }
     public void giveFood(Traveler traveler, int numOfFoodUnits){
        if (this.getFood() >= numOfFoodUnits) {
            traveler.food += numOfFoodUnits;
            this.food-= numOfFoodUnits;
        }
     }


}


