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
public class BoardingRecordDirectory {
    
    private ArrayList<PetBoardingRecord> recordList = new ArrayList<>();
    
    //Constructor 
    public BoardingRecordDirectory(){
    }
    
    public ArrayList<PetBoardingRecord> getRecordList() {
        return recordList;
    }
    //add new boarding record
    public PetBoardingRecord addRecord(String recordId, Pet pet, String startDate,
                                       String endDate, String roomNumber, 
                                       String notes, String status) {

        PetBoardingRecord record = new PetBoardingRecord(recordId, pet, startDate,
                                                         endDate, roomNumber, notes, status);

        recordList.add(record);
        return record;
    }
    //add existing record from list
    public void addRecord(PetBoardingRecord record) {
        recordList.add(record);
    }

    //remove exsting record from list
    public void removeRecord(PetBoardingRecord record) {
        recordList.remove(record);
    }

    //search record by recordId
    public PetBoardingRecord findRecordById(String recordId) {
        for (PetBoardingRecord record : recordList) {
            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        return null;
    }
}
