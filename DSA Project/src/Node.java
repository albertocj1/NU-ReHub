import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

class Node {

    private String researchTitle;
    private String researchAuthor;
    private String yearPublished;
    private String researchDOI;
    private String researchCourse;
    private String typeDoc;
    private String[] researchGenres; 

    public Node(String researchTitle, String researchAuthor, String yearPublished, String researchDOI, String researchCourse, String typeDoc, String[] researchGenres) {
        this.researchTitle = researchTitle;
        this.researchAuthor = researchAuthor;
        this.yearPublished = yearPublished;
        this.researchDOI = researchDOI;
        this.researchCourse = researchCourse;
        this.typeDoc = typeDoc;
        // this.pdfFile = pdfFile;
        this.researchGenres = researchGenres;
    }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }


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

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
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

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    // public String getPdfFile() {
    //     return pdfFile;
    // }

    // public void setPdfFile(String pdfFile) {
    //     this.pdfFile = pdfFile;
    // }

    public String getResearchGenresString() {
        String researchGenresData = Arrays.toString(researchGenres);
        return researchGenresData;
    }

    public String[] getResearchGenres() {
        return researchGenres;
    }

    public void setResearchGenres(String[] researchGenres) {
        this.researchGenres = researchGenres;
    }

}


