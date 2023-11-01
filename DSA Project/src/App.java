import java.util.HashMap;

class App {

    HashMap<String, Node> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        App v1App = new App();
        v1App.researchCompileInsert();
        System.out.println(v1App.nodeMap);

        String nodeId = "10.5678/ijkl9012"; // Replace this with the actual node ID you want to retrieve
        Node node = v1App.nodeMap.get(nodeId);
        if (node != null) {
            String researchTitle = node.getResearchTitle();
            System.out.println("Research Title: " + researchTitle);
        } else {
            System.out.println("Node with ID " + nodeId + " not found.");
        }

        v1App.addNode("Enhancing Mobile Web Application using ML", "De Luna, M.", "2023", "10.5678/ijkl90123", "BSCS-ML", "Internship",new String[]{"Machine Learning", "CyberSecurity"});
        System.out.println(v1App.nodeMap);
    }

    public void researchCompileInsert() {
        DataSample dataSample = new DataSample();
        Object[][] researchData = dataSample.getDataSample();

        for (Object[] entry : researchData) {
            String inputTitle = (String) entry[1];
            String inputAuthor = (String) entry[3];
            String inputYearPublished = (String) entry[5];
            String inputDOI = (String) entry[7];
            String inputCourse = (String) entry[9];
            String inputTypeDoc = (String) entry[11];

            
            String[] inputGenres;
            if (entry[13] instanceof String[]) {
                inputGenres = (String[]) entry[13];
            } else {
                // Handle the case where entry[5] is a single string, convert it to an array
                inputGenres = new String[]{(String) entry[11]};
            }

            Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputTypeDoc, inputGenres);
            nodeMap.put(inputDOI, researchNode);
        }
    }

    public void addNode(String inputTitle, String inputAuthor, String inputYearPublished, String inputDOI, String inputCourse, String inputTypeDoc, String[] inputGenres) {
        Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputTypeDoc,inputGenres);
        nodeMap.put(inputDOI, researchNode);
    }

    public void deleteNode(Node node) {
        nodeMap.remove(node.getResearchDOI());
    }

    public void updateTitle(Node node, String newTitle) {
        node.setResearchTitle(newTitle);
    }

    public void updateAuthor(Node node, String newAuthor) {
        node.setResearchAuthor(newAuthor);
    }

    public void updateYearPublished(Node node, String newYearPublished) {
        node.setYearPublished(newYearPublished);
    }

    public void updateDOI(Node node, String newDOI) {
        node.setResearchDOI(newDOI);
    }

    public void updateCourse(Node node, String newCourse) {
        node.setResearchCourse(newCourse);
    }

    public void updateTypeDoc(Node node, String newTypeDoc) {
        node.setTypeDoc(newTypeDoc);
    }

    public void updateGenres(Node node, String[] newGenres) {
        node.setResearchGenres(newGenres);
    }

    
}




