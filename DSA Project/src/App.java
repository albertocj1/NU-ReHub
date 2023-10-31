import java.util.HashMap;

class App {
    public static void main(String[] args) {
        ResearchCompilation researchCompilation = new ResearchCompilation();
        researchCompilation.researchCompileInsert();
        System.out.println(researchCompilation.nodeMap);

        // String nodeId = "Daniel Thompson"; // Replace this with the actual node ID you want to retrieve
        // Node node = researchCompilation.nodeMap.get(nodeId);
        // if (node != null) {
        //     String researchTitle = node.getResearchTitle();
        //     System.out.println("Research Title: " + researchTitle);
        // } else {
        //     System.out.println("Node with ID " + nodeId + " not found.");
        // }
    }
}


// Hashtable -> Node
// Record of researches
class ResearchCompilation{  
    HashMap<String, Node> nodeMap = new HashMap<>();

    public void researchCompileInsert() {
        DataSample dataSample = new DataSample();
        Object[][] researchData = dataSample.getDataSample();
        // System.out.println((String) researchData[1][5]);
        // System.out.println("--------------------");
        for (Object[] entry : researchData) {
            String inputTitle = (String) entry[1];
            String inputAuthor = (String) entry[3];
            String inputYearPublished = (String) entry[5];
            String inputDOI = (String) entry[7];
            String inputCourse = (String) entry[9];

            
            String[] inputGenres;
            if (entry[5] instanceof String[]) {
                inputGenres = (String[]) entry[5];
            } else {
                // Handle the case where entry[5] is a single string, convert it to an array
                inputGenres = new String[]{(String) entry[5]};
            }

            Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputGenres);
            nodeMap.put(inputDOI, researchNode);
        }
    }
    
}

class Node {

    private String researchTitle;
    private String researchAuthor;
    private String yearPublished;
    private String researchDOI;
    private String researchCourse;
    private String[] researchGenres; 

    public Node(String researchTitle, String researchAuthor, String yearPublished, String researchDOI, String researchCourse, String[] researchGenres) {
        this.researchTitle = researchTitle;
        this.researchAuthor = researchAuthor;
        this.yearPublished = yearPublished;
        this.researchDOI = researchDOI;
        this.researchCourse = researchCourse;
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

    // public String getPdfFile() {
    //     return pdfFile;
    // }

    // public void setPdfFile(String pdfFile) {
    //     this.pdfFile = pdfFile;
    // }

    public String[] getResearchGenres() {
        return researchGenres;
    }

    public void setResearchGenres(String[] researchGenres) {
        this.researchGenres = researchGenres;
    }

    
}
