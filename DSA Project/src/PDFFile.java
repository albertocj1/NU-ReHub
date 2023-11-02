import java.io.File;

public class PDFFile {
    
    public static void main(String[] args) {
        getfullpath("/PDFs/1.pdf");
    }

    public static String getfullpath(String abspath) {
        File directory = new File("src");
        String loc = directory.getAbsolutePath() + abspath;

        return loc;
    }
}
