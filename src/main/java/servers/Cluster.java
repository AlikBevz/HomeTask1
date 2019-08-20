package servers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.RandomNodeException;
import exception.RandomServerException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cluster {

    transient Optional<Server> serverOptional;
    List<Optional<Server>> optionalListForServer = new ArrayList<>();




    private static final Random RANDOM = new Random();

    transient private int amountOfServerInCluster = RANDOM.nextInt(10);

    public Cluster() {
    }

    public List<Optional<Server>> getOptionalListForServer() {
        return optionalListForServer;
    }

    public void setOptionalListForServer(List<Optional<Server>> optionalListForServer) {
        this.optionalListForServer = optionalListForServer;
    }

    public int getAmountOfServerInCluster() {
        return amountOfServerInCluster;
    }

    public List<Optional<Server>> formedServerForCluster() {

        for (int i = 0; i < amountOfServerInCluster; i++) {

            if (Math.random() > 0.5) {
                serverOptional = new Optional<>(new Server(i));
                System.out.println("server number -" + serverOptional.get().getNumber() + " is presented in cluster -  " + serverOptional.isPresent());
                optionalListForServer.add(serverOptional);

            } else {
                serverOptional = new Optional<>(null);
                System.out.println("server number -" + i + " is presented in cluster - " + serverOptional.isPresent());
            }


        }
        return optionalListForServer;
    }

    public void formedNodeForServersInCluster() {

        for (Optional<Server> serverOptional : this.getOptionalListForServer()) {

            serverOptional.get().setOptionalListOfNode(serverOptional.get().formNodeForServer());

        }
    }

    public void printCluster() {
        for (Optional<Server> serverOptional : this.getOptionalListForServer()) {

            System.out.println();

            if (serverOptional.get().getAmountOfNode()> 0){

                System.out.println("server number - " + serverOptional.get().getNumber() + " total number of nodes is  " + serverOptional.get().getAmountOfNode() +
                               " but now is presented such as:  ");}

               else System.out.println("server number - " + serverOptional.get().getNumber() + " total number of nodes is  " + serverOptional.get().getAmountOfNode());

            for (Optional<Node> nodeOptional : serverOptional.get().getOptionalListOfNode()) {

                System.out.println("node number - " + nodeOptional.get().getNumber() + " is  presents in server and status is " + nodeOptional.get().getStatus());

            }
        }

    }

    public void sendMessage() {

        try {
            int randomForServer = (int) (Math.random() * this.getOptionalListForServer().size() - 1);

            if (randomForServer > this.getOptionalListForServer().size() - 1) {
                throw new RandomServerException();
            }

            int amountOfNodeInServer = this.getOptionalListForServer().get(randomForServer).get().getOptionalListOfNode().size()-1;

            int randomForNode = (int) (Math.random() * /*amountOfNodeInServer*/ 5);

            if (randomForNode > amountOfNodeInServer - 1) {
                throw new RandomNodeException();
            }


            for (int i = randomForNode; i < this.getOptionalListForServer().get(randomForServer).get().getOptionalListOfNode().size(); i++) {


                this.getOptionalListForServer().get(randomForServer).get().getOptionalListOfNode().get(i).get().setStatus(true);

            }

            for (int i = randomForServer+1; i < this.getOptionalListForServer().size(); i++){

                for (int j = 0; j < this.getOptionalListForServer().get(i).get().getOptionalListOfNode().size(); j++){

                    this.getOptionalListForServer().get(i).get().getOptionalListOfNode().get(j).get().setStatus(true);
                }

            }



        }

        catch(ArrayIndexOutOfBoundsException e){

            System.out.println();
            System.out.println("NO SUCH NODE IN SERVER WHICH RECEIVE SEND MESSAGE");
        }

        catch(RandomServerException e){
            System.out.println();
            System.out.println("NO SUCH NUMBER OF SERVER IN CLUSTER WHICH RECEIVE SEND MESSAGE ");
        }

        catch(RandomNodeException e){
            System.out.println();
            System.out.println("NO SUCH NODE IN SERVER WHICH RECEIVE SEND MESSAGE");
        }


    }

    public boolean isFailed(int serverNumber, int nodeNumber){

        return this.getOptionalListForServer().get(serverNumber).get().getOptionalListOfNode().get(nodeNumber).get().getStatus();




    }

    public void toJSONinFile(String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter(fileName);

        gson.toJson(this, fileWriter);

        fileWriter.flush();

        fileWriter.close();


    }


}

