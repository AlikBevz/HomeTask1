package servers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server {
    private int number;
    private List<Optional<Node>> optionalListOfNode = new ArrayList<>();
    Optional <Node> nodeOptional;

    private static final Random RANDOM = new Random();

    private int amountOfNodeInServer = RANDOM.nextInt(10);


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

    public  List<Optional<Node>>  formNodeForServer(){

       for (int i = 0; i < amountOfNodeInServer; i++) {

            if (Math.random() > 0.5) {

                nodeOptional = new Optional<>(new Node(i, false));

               // System.out.println("Node number - " + nodeOptional.get().getNumber() + " has status - " + nodeOptional.get().getStatus() + "  and present is - " +
                 //       nodeOptional.isPresent());

                optionalListOfNode.add(nodeOptional);



            } else {
                nodeOptional = new Optional<>(null);
                //System.out.println("Node number  - " + i + " present is -" + nodeOptional.isPresent());
            }


        }

      return optionalListOfNode;
    }

}
