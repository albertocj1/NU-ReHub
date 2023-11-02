import java.io.File;

public class PDFFile {
    
    public static void main(String[] args) {
        // getfullpath("/PDFs/1.pdf");
        String word = "Machine Learning";
        if(word.contains("Mach")) {
            System.out.println("true");
        }
    }

    public static String getfullpath(String abspath) {
        File directory = new File("src");
        String loc = directory.getAbsolutePath() + abspath;

        return loc;
    }
}
