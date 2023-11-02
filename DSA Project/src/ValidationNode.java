public class ValidationNode {
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static boolean checkResearch(String inputTitle) {
        if (inputTitle.length() > 0) {
            return true;
        } else {
            System.out.println("Invalid input. Please enter a valid title.");
            return false;
        }
    }

    public static boolean checkAuthor(String inputAuthor) {
        if (inputAuthor.length() > 0) {
            return true;
        } else {
            System.out.println("Invalid input. Please enter a valid author.");
            return false;
        }
    }

    public static boolean checkYear(String yearPublished) {
        if (yearPublished.length() == 4) {
            if (yearPublished.matches("[0-9]+")) {
                return true;
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                return false;
            }
        } else {
            System.out.println("Invalid input. Please enter a valid year.");
            return false;
        }
    }

    public static boolean checkDOI(String inputDOI) {
        if (inputDOI.length() > 0) {
            return true;
        } else {
            System.out.println("Invalid input. Please enter a valid DOI.");
            return false;
        }
    }

    public static boolean checkCourse(String inputCourse) {
        String[] courses = {"BSCS-ML", "BSIT-MWA", "BSIT-MAA", "BSCS-DF"};
        for (String course : courses) {
            if (inputCourse.equals(course.toUpperCase())) {
                return true;
            }
        }
        return false;
    }   

    public static boolean checkTypeDoc(String inputDocType) {
        String[] typesDoc = {"internship", "thesis", "capstone"};
        for (String doc : typesDoc) {
            if (doc.equals(inputDocType.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkGenres(String[] inputGenres) {
        if (inputGenres.length <= 2) {
            return true;
        }
        return false;
    }
}
