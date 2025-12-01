/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

/**
 *
 * @author jingyangwang
 */
public class Pet {
    
    //set the pet's attributes
    private String petId;
    private String petName;
    private String species;      // dog or cat ONLY
    private int age;
    private double weight;

    private String foodPreference;
    private String foodAllergy;
    private String healthNotes;

    private PetOwner petOwner;  
    private InsurancePolicy insurancePolicy;
    
    
    //Constructor
    public Pet() {
    }

    public Pet(String petId, String petName, String species, int age, double weight,
               String foodPreference, String foodAllergy, String healthNotes, PetOwner petOwner) {

        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.foodPreference = foodPreference;
        this.foodAllergy = foodAllergy;
        this.healthNotes = healthNotes;
        this.petOwner = petOwner;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public String getFoodAllergy() {
        return foodAllergy;
    }

    public void setFoodAllergy(String foodAllergy) {
        this.foodAllergy = foodAllergy;
    }

    public String getHealthNotes() {
        return healthNotes;
    }

    public void setHealthNotes(String healthNotes) {
        this.healthNotes = healthNotes;
    }

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }
    // ⭐ 新增 Getter 和 Setter
    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
    /*  暂时未知用来做什么
    @Override
    public String toString() {
        return petName;   // UI table / dropdown 显示宠物名
    }
    */ 


}

