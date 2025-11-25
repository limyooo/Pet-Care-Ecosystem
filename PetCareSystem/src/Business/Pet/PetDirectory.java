/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

import java.util.ArrayList;

/**
 *
 * @author jingyangwang
 */
public class PetDirectory {
    
    private ArrayList<Pet> petList = new ArrayList<>();
    
    //Constructor
    public PetDirectory() {
    }
    //get Petlist method
    public ArrayList<Pet> getPetList() {
        return petList;
    }
    //add pet method with full variables
    public Pet addPet(String petId, String petName, String species, int age, double weight,
                      String foodPreference, String foodAllergy, String healthNotes, PetOwner owner) {

        Pet pet = new Pet(petId, petName, species, age, weight,
                          foodPreference, foodAllergy, healthNotes, owner);
        petList.add(pet);
        return pet;
    }

    //add pet to the list method
    public void addPet(Pet pet) {
        petList.add(pet);
    }

    //remove pet from the list method
    public void removePet(Pet pet) {
        petList.remove(pet);
    }

    //search pet by petId  method
    public Pet findPetById(String petId) {
        for (Pet pet : petList) {
            if (pet.getPetId().equals(petId)) {
                return pet;
            }
        }
        return null;
    }
}

