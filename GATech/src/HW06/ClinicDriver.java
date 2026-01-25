package HW06;

import java.io.FileNotFoundException;

public class ClinicDriver {
    public static void main(String[] args) {
        Clinic clinic = new Clinic("Patients.csv");
        System.out.println("Working directory: " + new java.io.File(".").getAbsolutePath());
        String dayOneReport = "";
        try {
            dayOneReport = clinic.nextDay("Appointments.csv");
        } catch (FileNotFoundException | InvalidPetException exception) {
            exception.printStackTrace();
        }
        String[] dayOneAppointments = dayOneReport.split("\\n");
        for (String appointment : dayOneAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
    }
}
