public class DataSample {

    public Object[][] dataSample = new Object[][] {
        {
            "researchTitle", "A Comparative Study of Machine Learning Algorithms for Predictive Analytics in E-Commerce",
            "researchAuthor", "John Smith",
            "yearPublished", "2020",
            "researchDOI", "10.5678/abcd1234",
            "researchCourse", "Data Science",
            "researchGenres", new String[]{"Predictive Analytics", "E-Commerce", "Machine Learning"}
        },
        {
            "researchTitle", "Scalability and Performance Optimization in Modern Web Applications",
            "researchAuthor", "Michael Anderson",
            "yearPublished", "2018",
            "researchDOI", "10.5678/efgh5678",
            "researchCourse", "Web Development",
            "researchGenres", new String[]{"Scalability", "Web Applications", "Performance Optimization"}
        },
        {
            "researchTitle", "Mitigating Cybersecurity Threats in Internet of Things (IoT) Devices",
            "researchAuthor", "Sarah Martinez",
            "yearPublished", "2017",
            "researchDOI", "10.5678/ijkl9012",
            "researchCourse", "Cybersecurity",
            "researchGenres", new String[]{"IoT Security", "Cyber Threats", "Network Security"}
        },
        {
            "researchTitle", "Advancements in Natural Language Processing using Deep Learning Techniques",
            "researchAuthor", "David Kim",
            "yearPublished", "2019",
            "researchDOI", "10.5678/mnop3456",
            "researchCourse", "Machine Learning",
            "researchGenres", new String[]{"Natural Language Processing", "Deep Learning", "Text Mining"}
        },
        {
            "researchTitle", "Exploring Generative Adversarial Networks (GANs) for Image Synthesis",
            "researchAuthor", "Jessica Lee",
            "yearPublished", "2016",
            "researchDOI", "10.5678/qrst5678",
            "researchCourse", "Deep Learning",
            "researchGenres", new String[]{"Generative Adversarial Networks", "Image Synthesis", "Computer Vision"}
        },
        {
            "researchTitle", "Ethical Considerations in AI: Ensuring Fairness and Accountability in Autonomous Systems",
            "researchAuthor", "Daniel Thompson",
            "yearPublished", "2021",
            "researchDOI", "10.5678/uvwx1234",
            "researchCourse", "Artificial Intelligence",
            "researchGenres", new String[]{"Ethical AI", "Autonomous Systems", "Fairness in AI"}
        }
    };

    public Object[][] getDataSample() {
        System.out.println("Successfully retrieved data sample.");
        return dataSample;
    }
}
