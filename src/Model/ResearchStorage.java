package Model;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class ResearchStorage {

    static HashMap<String, Node> nodeMap = new HashMap<>();
    static DataSample dataSampleInstance = new DataSample();
    static HashMap<String, Node> copyNodeMap = new HashMap<>();
    static String[] filteredList;

    static {
        Object[][] predefinedData = dataSampleInstance.getDataSample();
        for (Object[] data : predefinedData) {
            String title = (String) data[1];
            String author = (String) data[3];
            String yearPublished = (String) data[5];
            String  doi = (String) data[7];
            String course = (String) data[9];
            String typeDoc = (String) data[11];
            String[] genres = (String[]) data[13];
            addNode(title, author, yearPublished, doi, course, typeDoc, genres);
        }
    }

    public static void addNode(String inputTitle, String inputAuthor, String inputYearPublished, String inputDOI, String inputCourse, String inputTypeDoc, String[] inputGenres) {
        Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputTypeDoc,inputGenres);
        nodeMap.put(inputDOI, researchNode);
    }

    public static void deleteNode(Node node) {
        nodeMap.remove(node.getResearchDOI());
    }

    public static void updateTitle(Node node, String newTitle) {
        node.setResearchTitle(newTitle);
    }

    public static void updateAuthor(Node node, String newAuthor) {
        node.setResearchAuthor(newAuthor);
    }

    public static void updateYearPublished(Node node, String newYearPublished) {
        node.setYearPublished(newYearPublished);
    }

    public static void updateDOI(Node node, String newDOI) {
        node.setResearchDOI(newDOI);
    }

    public static void updateCourse(Node node, String newCourse) {
        node.setResearchCourse(newCourse);
    }

    public static void updateTypeDoc(Node node, String newTypeDoc) {
        node.setTypeDoc(newTypeDoc);
    }

    public static void updateGenres(Node node, String[] newGenres) {
        node.setResearchGenres(newGenres);
    }

    public static void printNodes() {
        System.out.println(nodeMap);
    }

    public static Node getNode(String doi) {
        return nodeMap.get(doi);
    }

    public static String[] giveKeys() {
        return nodeMap.keySet().toArray(new String[0]);
    }

    public static String[] filterCourses(String course) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = nodeMap.get(node);
            String rCourse = researchNode.getResearchCourse().toLowerCase();
            if (!rCourse.equals(course.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }
    
    public static String[] filterTypes(String type) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = nodeMap.get(node);
            String typeDoc = researchNode.getTypeDoc().toLowerCase();
            if (!typeDoc.equals(type.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }

    public static String[] filterYears(String year) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = nodeMap.get(node);
            String rYear = researchNode.getYearPublished().toLowerCase();
            if (!rYear.equals(year.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }
    
    private static String[] convertListToArray(List<String> list) {
        String[] array = new String[list.size()];
        return list.toArray(array);
    }

    public static void resetCloneMap() {
        copyNodeMap = new HashMap<>(nodeMap);
        List<String> researchNodes = new ArrayList<>(copyNodeMap.keySet());
        filteredList = convertListToArray(researchNodes);
    }

    public static String[] searchKeyword(String keyword) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = nodeMap.get(node);
            String rTitle = researchNode.getResearchTitle().toLowerCase();
            if (!rTitle.contains(keyword.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }

    public static List<String> combinedFilter(String types, String courses, String year) {
        resetCloneMap();
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = nodeMap.get(node);
            String rType = researchNode.getTypeDoc().toLowerCase();
            String rCourse = researchNode.getResearchCourse().toLowerCase();
            String rYear = researchNode.getYearPublished().toLowerCase();
            if (!rType.equals(types.toLowerCase()) || !rCourse.equals(courses.toLowerCase()) || !rYear.equals(year.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredNodes;
    }

    public static String[] filterGenres(String genre) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = nodeMap.get(node);
            String[] genres = researchNode.getResearchGenres();
            boolean found = false;
    
            // Check if the genre is present in the research node
            for (String g : genres) {
                if (g.equalsIgnoreCase(genre)) {
                    found = true;
                    break;
                }
            }
    
            if (!found) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }
    
    

    public static void main(String[] args) {
        // printNodes();
        resetCloneMap(); // Initialize the filteredList array
        // combinedFilter("Internship", "BSCS-ML", "2022");
        // System.out.println("Filtered Nodes:");
        // for (String doi : filteredList) {
        //     System.out.println(doi); // Assuming you have overridden toString() method in Node class
        // }
        List<String> filteredDoi = ResearchStorage.combinedFilter("Internship", "BSCS-ML", "2022");
        String[] stringArray = filteredDoi.toArray(new String[0]);
        for (String qwe : stringArray) {
            System.out.println(qwe);
        }
        
    }
    
}
