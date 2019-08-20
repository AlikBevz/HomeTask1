package servers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server {
    @SerializedName("numberServer")
    private int number;


    private List<Optional<Node>> optionalListOfNode = new ArrayList<>();

    transient Optional <Node> nodeOptional;

    private static final Random RANDOM = new Random();

     transient private int amountOfNodeInServer = RANDOM.nextInt(10);


    public Server(int number, List<Optional<Node>> optionalListOfNode) {
        this.number = number;
        this.optionalListOfNode = optionalListOfNode;
    }

    public Server() {
    }

    public Server(int number) {
        this.number = number;
    }

    public int getAmountOfNode() {
        return amountOfNodeInServer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Optional<Node>> getOptionalListOfNode() {
        return optionalListOfNode;
    }

    public void setOptionalListOfNode(List<Optional<Node>> optionalListOfNode) {
        this.optionalListOfNode = optionalListOfNode;
    }

    public Optional<Node> getNodeOptional() {
        return nodeOptional;
    }


    public  List<Optional<Node>>  formNodeForServer() {

        for (int i = 0; i < amountOfNodeInServer; i++) {

            if (Math.random() > 0.5) {

                nodeOptional = new Optional<>(new Node(i, false));



                optionalListOfNode.add(nodeOptional);



            } else {
                nodeOptional = new Optional<>(null);

            }


        }

        return optionalListOfNode;
    }

    public void toJson()throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("test.log");

        gson.toJson(optionalListOfNode, fileWriter);

        fileWriter.flush();

        fileWriter.close();



    }

}
