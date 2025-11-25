/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.PetBoardingOrganization.BoardingServiceOrganization;
import Business.PetBoardingOrganization.PetCareOrganization;
import Business.PetClinicOrganization.FrontDeskOrganization;
import Business.PetClinicOrganization.VetDoctorOrganization;
import Business.PetClinicOrganization.VetLabOrganization;
import Business.PetInsuranceOrganization.InsuranceClaimOrganization;
import Business.PetInsuranceOrganization.InsurancePolicyOrganization;
import java.util.ArrayList;

/**
 * OrganizationDirectory:
 * Stores and creates all organizations under an Enterprise.
 */
public class OrganizationDirectory {

    // List of all organizations belonging to one enterprise
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        // Initialize empty list when directory is created
        organizationList = new ArrayList<>();
    }

    // Return the list so UI / enterprise can iterate over organizations
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    /**
     * Factory method:
     * Create a concrete Organization based on the given Type
     * and add it into this directory.
     */
    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;

        switch (type) {
            case PetCare:
                organization = new PetCareOrganization();
                break;
            case BoardingService:
                organization = new BoardingServiceOrganization();
                break;
            case VetDoctor:
                organization = new VetDoctorOrganization();
                break;
            case VetLab:
                organization = new VetLabOrganization();
                break;
            case FrontDesk:
                organization = new FrontDeskOrganization();
                break;
            case InsurancePolicy:
                organization = new InsurancePolicyOrganization();
                break;
            case InsuranceClaim:
                organization = new InsuranceClaimOrganization();
                break;
            default:
                // no-op
                break;
        }

        // If we successfully created one, add it to the list
        if (organization != null) {
            organizationList.add(organization);
        }

        return organization;
    }
}
