import java.util.HashMap;

class App {

    HashMap<String, Node> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        App v1App = new App();
        v1App.researchCompileInsert();

        // Print the node map
        System.out.println(v1App.nodeMap);

        String nodeId = "10.5678/ijkl9012"; // Replace this with the actual node ID you want to retrieve
        Node node = v1App.nodeMap.get(nodeId);
        if (node != null) {
            String researchTitle = node.getResearchTitle();
            System.out.println("Research Title: " + researchTitle);
            node.setResearchTitle("New Title");
            System.out.println("new: " + node.getResearchTitle());
        } else {
            System.out.println("Node with ID " + nodeId + " not found.");
        }
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

            
            String[] inputGenres;
            if (entry[11] instanceof String[]) {
                inputGenres = (String[]) entry[11];
            } else {
                // Handle the case where entry[5] is a single string, convert it to an array
                inputGenres = new String[]{(String) entry[11]};
            }

            Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputGenres);
            nodeMap.put(inputDOI, researchNode);
        }
    }

    public void add(Node node, String inputTitle, String inputAuthor, String inputYearPublished, String inputDOI, String inputCourse, String[] inputGenres) {
        Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputGenres);
        nodeMap.put(inputDOI, researchNode);
    }

    public void delete(Node node) {
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

    public void updateGenres(Node node, String[] newGenres) {
        node.setResearchGenres(newGenres);
    }

    
}




