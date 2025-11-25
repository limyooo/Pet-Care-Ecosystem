/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

/**
 *
 * @author jingyangwang
 */
public class PetBoardingRecord {
    
    //set the PetBoardingRecord attributes
    private String recordId;
    private Pet pet;
    private String startDate;
    private String endDate;
    private String roomNumber;
    private String notes;
    private String status;
    
    //Constructor
    public PetBoardingRecord(){
    
    }
    
    public PetBoardingRecord(String recordId, Pet pet, String startDate, String endDate,
                             String roomNumber, String notes, String status) {

        this.recordId = recordId;
        this.pet = pet;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.notes = notes;
        this.status = status;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //display recordId
    @Override
    public String toString() {
        return recordId;    // UI 下拉框显示 record ID
    }
}
