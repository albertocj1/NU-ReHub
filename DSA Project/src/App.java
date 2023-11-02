import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class App {

    HashMap<String, Node> nodeMap = new HashMap<>();
    HashMap<String, Node> copyNodeMap = new HashMap<>();
    static String[] filteredList;


    public static void main(String[] args) {
        App v1App = new App();
        v1App.researchCompileInsert();
        // System.out.println(v1App.nodeMap);

        // String nodeId = "10.5678/ijkl9012"; // Replace this with the actual node ID you want to retrieve
        // Node node = v1App.nodeMap.get(nodeId);
        // if (node != null) {
        //     String researchTitle = node.getResearchAuthor();
        //     System.out.println("Research Title: " + researchTitle);
        // } else {
        //     System.out.println("Node with ID " + nodeId + " not found.");
        // }

        // v1App.addNode("Enhancing Mobile Web Application using ML", "De Luna, M.", "2023", "10.5678/ijkl90123", "BSCS-ML", "Internship",new String[]{"Machine Learning", "CyberSecurity"});
        // System.out.println(v1App.nodeMap);
        // System.out.println();
        // System.out.println(v1App.nodeMap.keySet());
        // String[] listFiltered = v1App.filterYears("2022");
        // System.out.println(Arrays.toString(listFiltered));

        // Filter by course
        v1App.resetCloneMap();
        String[] filteredbyWord = v1App.searchKeyword("Machine");
        System.out.println(Arrays.toString(filteredbyWord));
        // String[] filteredByCourse = v1App.filterCourses("BSCS-ML");
        // System.out.println("Filtered by Course (BSCS-ML): " + Arrays.toString(filteredByCourse));

        // // Filter by year
        // String[] filteredByYear = v1App.filterYears("2019");
        // System.out.println("Filtered by Year (2019): " + Arrays.toString(filteredByYear));

        // // Filter by type
        // String[] filteredByType = v1App.filterTypes("Internship");
        // System.out.println("Filtered by Type (Thesis): " + Arrays.toString(filteredByType));
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
        Boolean validationGoods = true;
        Boolean[] validation = {ValidationNode.checkResearch(inputTitle), ValidationNode.checkAuthor(inputAuthor), ValidationNode.checkYear(inputYearPublished), ValidationNode.checkDOI(inputDOI), ValidationNode.checkCourse(inputCourse), ValidationNode.checkTypeDoc(inputTypeDoc), ValidationNode.checkGenres(inputGenres)};
        
        for (Boolean validations : validation) {
            if (validations == false) {
                validationGoods = false;
                break;
            } 
        }

        if (validationGoods == true) {
            Node researchNode = new Node(inputTitle, inputAuthor, inputYearPublished, inputDOI, inputCourse, inputTypeDoc, inputGenres);
            nodeMap.put(inputDOI, researchNode);
        } else {
            System.out.println("id input. Please try again.");
        }
    }

    public void deleteNode(Node node) {
        nodeMap.remove(node.getResearchDOI());
    }

    public void updateTitle(Node node, String newTitle) {
        if (ValidationNode.checkResearch(newTitle) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated title.");
            node.setResearchTitle(newTitle);
        }
    }

    public void updateAuthor(Node node, String newAuthor) {
        if (ValidationNode.checkAuthor(newAuthor) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated author.");
            node.setResearchAuthor(newAuthor);
        }
    }

    public void updateYearPublished(Node node, String newYearPublished) {
        if (ValidationNode.checkYear(newYearPublished) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated year published.");
            node.setYearPublished(newYearPublished);
        }
    }

    public void updateDOI(Node node, String newDOI) {
        if (ValidationNode.checkDOI(newDOI) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated DOI.");
            node.setResearchDOI(newDOI);
        }
    }

    public void updateCourse(Node node, String newCourse) {
        if (ValidationNode.checkCourse(newCourse) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated course.");
            node.setResearchCourse(newCourse);
        }
    }

    public void updateTypeDoc(Node node, String newTypeDoc) {
        if (ValidationNode.checkTypeDoc(newTypeDoc) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated document type.");
            node.setTypeDoc(newTypeDoc);
        }
    }

    public void updateGenres(Node node, String[] newGenres) {
        if (ValidationNode.checkGenres(newGenres) == false) {
            System.out.println("Invalid input. Please try again.");
            return;
        } else {
            System.out.println("Successfully updated genres.");
            node.setResearchGenres(newGenres);
        }
    }

    public String[] filterCourses(String course) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = this.nodeMap.get(node);
            String rCourse = researchNode.getResearchCourse().toLowerCase();
            if (!rCourse.equals(course.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }
    
    public String[] filterTypes(String type) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = this.nodeMap.get(node);
            String typeDoc = researchNode.getTypeDoc().toLowerCase();
            if (!typeDoc.equals(type.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }

    public String[] filterYears(String year) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = this.nodeMap.get(node);
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

    public void resetCloneMap() {
        this.copyNodeMap = new HashMap<>(this.nodeMap);
        List<String> researchNodes = new ArrayList<>(this.copyNodeMap.keySet());
        filteredList = convertListToArray(researchNodes);
    }

    public String[] searchKeyword(String keyword) {
        List<String> filteredNodes = new ArrayList<>(Arrays.asList(filteredList));
    
        Iterator<String> iterator = filteredNodes.iterator();
        while (iterator.hasNext()) {
            String node = iterator.next();
            Node researchNode = this.nodeMap.get(node);
            String rTitle = researchNode.getResearchTitle().toLowerCase();
            if (!rTitle.contains(keyword.toLowerCase())) {
                iterator.remove(); // Use iterator to safely remove elements from the list
            }
        }
    
        // Convert the filteredNodes list to a String array
        filteredList = convertListToArray(filteredNodes);
        return filteredList;
    }



}




