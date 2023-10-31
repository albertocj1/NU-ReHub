import java.util.HashMap;

class App {
    public static void main(String[] args) {
        ResearchCompilation researchCompilation = new ResearchCompilation();
        researchCompilation.researchCompileInsert();
        System.out.println(researchCompilation.nodeMap);

        String nodeId = "10.5678/ijkl9012"; // Replace this with the actual node ID you want to retrieve
        Node node = researchCompilation.nodeMap.get(nodeId);
        if (node != null) {
            String researchTitle = node.getResearchGenresString();
            System.out.println("Research Title: " + researchTitle);
        } else {
            System.out.println("Node with ID " + nodeId + " not found.");
        }
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
    
}

