package edu.ucalgary.oop;

public class main {
    public static void main(String[] args) {
        // Create victims
        DisasterVictim victim1 = new DisasterVictim("John Doe", "2024-04-17");
        DisasterVictim victim2 = new DisasterVictim("Jane Doe", "2024-04-17");

        // Add family connection
        FamilyRelation familyRelation = new FamilyRelation(victim1, "sister", victim2);
        victim1.addFamilyConnection(familyRelation);
        victim2.addFamilyConnection(familyRelation);

        // Add medical records
        Location location = new Location("Some Place", "Some Address");
        MedicalRecord medicalRecord = new MedicalRecord(location, "Allergy", "2024-04-17", "Needs regular medication");
        victim1.addMedicalRecord(medicalRecord);

        // Manage personal belongings
        Supply supply = new Supply("Water Bottle", 1);
        victim1.addPersonalBelonging(supply, location);

        // Display some information
        System.out.println("Victim 1 Family Connections: " + victim1.getFamilyConnections().size());
        System.out.println("Victim 1 Medical Records: " + victim1.getMedicalRecords().size());
        System.out.println("Victim 1 Personal Belongings: " + victim1.getPersonalBelongings().size());
    }
}