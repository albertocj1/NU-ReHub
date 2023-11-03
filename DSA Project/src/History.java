import java.util.HashMap;

public class History {
    private HashMap<String, Node> nodeMap = new HashMap<>();
    private Node firstNode;
    private Node lastNode;

    public static void main(String[] args) {
        History v1History = new History();
        v1History.researchCompileInsert();
        System.out.println(v1History.nodeMap);

        String nodeId = "10.5678/ijkl9012"; // Replace this with the actual node ID you want to retrieve
        Node node = v1History.nodeMap.get(nodeId);
        if (node != null) {
            String researchTitle = node.getResearchAuthor();
            System.out.println("Research Title: " + researchTitle);
        } else {
            System.out.println("Node with ID " + nodeId + " not found.");
        }

        v1History.displayLinkedListTitles();
    }

    public void researchCompileInsert() {
        // Simulate adding nodes to the linked list and the nodeMap
        for (int i = 1; i <= 5; i++) {
            Node newNode = new Node("Title" + i, "Author" + i, "Abstract" + i);
            String nodeId = "10.5678/ijkl901" + i;

            // Add the node to the nodeMap
            nodeMap.put(nodeId, newNode);

            // Add the node to the linked list
            if (firstNode == null) {
                firstNode = newNode;
                lastNode = newNode;
            } else {
                lastNode.setNext(newNode);
                lastNode = newNode;
            }
        }
    }

    public void displayLinkedListTitles() {
        System.out.println("Linked List Titles:");
        Node current = firstNode;
        while (current != null) {
            System.out.println(current.getResearchTitle());
            current = current.getNext();
        }
    }
}

class Node {
    private String researchTitle;
    private String researchAuthor;
    private String researchAbstract;
    private Node next;

    public Node(String title, String author, String abstractText) {
        this.researchTitle = title;
        this.researchAuthor = author;
        this.researchAbstract = abstractText;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public String getResearchAuthor() {
        return researchAuthor;
    }

    public String getResearchAbstract() {
        return researchAbstract;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public Node getNext() {
        return next;
    }
}
