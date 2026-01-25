package HW06;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class Clinic {
    private File patientFile;
    private static int day = 1;

    public Clinic(File file) {
        this.patientFile = file;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        Scanner fileScan = new Scanner(f);
        Scanner keyInput = new Scanner(System.in);
        String line = null;
        String tokens[] = null;
        String strToReturn = "", delim = ",";

        while(fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            tokens = line.split(",");
            if((!tokens[1].equals("Dog")) && (!tokens[1].equals("Cat"))) {
                throw new InvalidPetException();
            }
            boolean validHealth = false, validPainLevel = false;
            double health = 0;
            int painLevel = 0;
            while(!validHealth) {
                System.out.println("Consultation for " + tokens[0] + " the " + tokens[1] + " at " + tokens[3] + ".\n" + //
                                "What is the health of " + tokens[0] + "?\n");
                if(!keyInput.hasNextDouble())
                    continue;
                else {
                    health = keyInput.nextDouble();
                    keyInput.nextLine();
                }
                validHealth = true;
            }
            while(!validPainLevel) {
                System.out.println("On a scale of 1 to 10, how much pain is " + tokens[0] + " in right now?\n");
                if(!keyInput.hasNextInt())
                    continue;
                else {
                    painLevel = keyInput.nextInt();
                    keyInput.nextLine();
                }
                validPainLevel = true;
            }
            Pet pet = null;
            if(tokens[1].equals("Dog"))
                pet = new Dog(tokens[0], health, painLevel, Double.parseDouble(tokens[2]));
            else
                pet = new Cat(tokens[0], health, painLevel, Integer.parseInt(tokens[2]));
            pet.speak();
            pet.treat();
            String timeOut = this.addTime(tokens[3], pet.treat());
            strToReturn = strToReturn + tokens[0] + delim + tokens[1] + delim + tokens[2] + delim + "Day " + day + delim + tokens[3] + delim + timeOut + delim + health + delim + painLevel + "\n";
        }
        day = day + 1;
        return strToReturn;
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo) {
        boolean addSuccess = false;
        String tokens[] = patientInfo.split(",");
        PrintWriter filePrint = null;
        boolean found = false;

        try {
            File fileOut = new File("Patients.csv");
            if (!fileOut.exists()) {
                return false;
            }

            File tempFile = new File("temp.csv");
            PrintWriter tempWriter = new PrintWriter(new FileWriter(tempFile));
            Scanner scan = new Scanner(fileOut);

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String lineBits[] = line.split(",");
                String existingName = lineBits[0];
                if(existingName.equals(tokens[0])) {
                    tempWriter.println(line + "," + patientInfo.substring(patientInfo.indexOf("Day")));
                    found = true;
                } else {
                // 5. Keep the line unchanged
                tempWriter.println(line);
                }
            }
            if (!found) {
                tempWriter.println(patientInfo);
            }

            tempWriter.close();
            fileOut.delete();
            tempFile.renameTo(fileOut);
            return true;
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        finally {
            if (filePrint != null) {
                filePrint.close();
            }
        }
    }

    public String addTime(String timeIn, int treatmentTime) {
        int timeIn_hours = Integer.parseInt(timeIn.substring(0, 2));
        int timeIn_minutes = Integer.parseInt(timeIn.substring(2));

        LocalTime time = LocalTime.of(timeIn_hours, timeIn_minutes);
        LocalTime newTime = time.plusMinutes(treatmentTime);

        return String.format("%02d%02d", newTime.getHour(), newTime.getMinute());
    }
}
