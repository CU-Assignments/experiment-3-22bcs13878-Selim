import java.util.Scanner;

public class academicEnroll {
    private static String[] preReq = {"Machine Learning", "Data Structures", "Algorithms"};
    private static int enrollment = 100;
    private static String[] courses = {"Deep Learning", "Artificial Intelligence", "Computer Vision"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Academic Enrollment System");

        System.out.print("Enter your prerequisite course: ");
        String preRequisite = sc.nextLine();

        System.out.print("Enter the course you want to enroll in: ");
        String selectedCourse = sc.nextLine();

        try {
            if (!isValidPrerequisite(preRequisite)) {
                throw new PrerequisiteException("Prerequisite course not met.");
            }
            
            enroll(selectedCourse);
            System.out.println("Enrollment successful in: " + selectedCourse);
            
        } catch (MaxEnrollmentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PrerequisiteException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Remaining enrollment slots: " + enrollment);
        }

        sc.close();
    }

    // Checks if the entered prerequisite course is valid
    public static boolean isValidPrerequisite(String preRequisite) {
        for (String p : preReq) {
            if (p.equalsIgnoreCase(preRequisite)) {
                return true;
            }
        }
        return false;
    }

    // Enrolls the student if slots are available
    public static void enroll(String course) throws MaxEnrollmentException {
        if (enrollment == 0) {
            throw new MaxEnrollmentException("Maximum enrollment limit reached.");
        }
        enrollment--; // Reduce the available seats
    }
}

// Custom Exception for Max Enrollment
class MaxEnrollmentException extends Exception {
    public MaxEnrollmentException(String message) {
        super(message);
    }
}

// Custom Exception for Prerequisite Not Met
class PrerequisiteException extends Exception {
    public PrerequisiteException(String message) {
        super(message);
    }
}
