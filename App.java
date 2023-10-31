import java.util.HashMap;

// Hashtable -> Node
// Record of researches
class ResearchCompilation{  
    HashMap<String, Node> nodeMap = new HashMap<>();
    
    Node research1 = new Node("")
}



class Node {
    private String researchTitle;
    private String researchAuthor;
    private int yearPublished;
    private String researchDOI;
    private String researchCourse;
    private String pdfFile;
    private String[] researchGenres;

    public Node(String researchTitle, String researchAuthor, int yearPublished, String researchDOI, String researchCourse, String pdfFile, String[] researchGenres) {
        this.researchTitle = researchTitle;
        this.researchAuthor = researchAuthor;
        this.yearPublished = yearPublished;
        this.researchDOI = researchDOI;
        this.researchCourse = researchCourse;
        this.pdfFile = pdfFile;
        this.researchGenres = researchGenres;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
    }

    public String getResearchAuthor() {
        return researchAuthor;
    }

    public void setResearchAuthor(String researchAuthor) {
        this.researchAuthor = researchAuthor;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getResearchDOI() {
        return researchDOI;
    }

    public void setResearchDOI(String researchDOI) {
        this.researchDOI = researchDOI;
    }

    public String getResearchCourse() {
        return researchCourse;
    }

    public void setResearchCourse(String researchCourse) {
        this.researchCourse = researchCourse;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String[] getResearchGenres() {
        return researchGenres;
    }

    public void setResearchGenres(String[] researchGenres) {
        this.researchGenres = researchGenres;
    }
}