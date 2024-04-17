package edu.ucalgary.oop;

import java.util.List;
import java.util.ArrayList;

public class DisasterVictim {
    private static int counter = 0;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private List<FamilyRelation> familyConnections = new ArrayList<>();
    private List<MedicalRecord> medicalRecords = new ArrayList<>();
    private List<Supply> personalBelongings = new ArrayList<>();
    private final String ENTRY_DATE;
    private String gender;
    private String comments;
    private int age;
    private List<String> genderOptions;
    private List<DietaryRestriction> dietaryRestrictions;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        if (!genderOptions.contains(gender)) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are " + genderOptions);
        }
        this.gender = gender.toLowerCase();
    }

    public List<DietaryRestriction> getDietaryRestrictions() {
        return new ArrayList<>(dietaryRestrictions);
    }

    public void setDietaryRestrictions(List<DietaryRestriction> dietaryRestrictions) {
        this.dietaryRestrictions = new ArrayList<>(dietaryRestrictions);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public List<FamilyRelation> getFamilyConnections() {
        return new ArrayList<>(familyConnections);
    }

    public List<MedicalRecord> getMedicalRecords() {
        return new ArrayList<>(medicalRecords);
    }

    public List<Supply> getPersonalBelongings() {
        return new ArrayList<>(personalBelongings);
    }

    public void addFamilyConnection(FamilyRelation relation) {
        if (relation != null && !this.familyConnections.contains(relation)) {
            this.familyConnections.add(relation);
            relation.getPersonTwo().getFamilyConnections().add(relation);
        }
    }

    public void removeFamilyConnection(FamilyRelation relation) {
        if (relation != null && this.familyConnections.contains(relation)) {
            this.familyConnections.remove(relation);
            relation.getPersonTwo().getFamilyConnections().remove(relation);
        }
    }

    public void addPersonalBelonging(Supply supply, Location location) {
        if (supply != null && !this.personalBelongings.contains(supply)) {
            this.personalBelongings.add(supply);
            //location.getAvailableSupplies().remove();
        }
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        personalBelongings.remove(unwantedSupply);
    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }

    public String getGender() {
        return gender;
    }

}