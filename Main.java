import search.FailSearchEngine;
import servers.Cluster;
import servers.Node;
import servers.Optional;
import servers.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Cluster cluster = new Cluster();
        FailSearchEngine failSearchEngine = new FailSearchEngine(cluster);

        List<Optional<Server>> optionalListForServer;

        System.out.println("Amount of server is  " + cluster.getAmountOfServerInCluster());

        //optionalListForServer = cluster.formedServerForCluster();
        cluster.setOptionalListForServer(cluster.formedServerForCluster());

        cluster.formedNodeForServersInCluster();

        cluster.printCluster();

        cluster.sendMessage();

        System.out.println();
        System.out.println("AFTER SEND MESSAGE");

        cluster.printCluster();

        failSearchEngine.search();



//        for (Optional<Server> serverOptional : cluster.getOptionalListForServer()) {
//
////            System.out.println();
////            System.out.println("Server number - " + serverOptional.get().getNumber());
////            System.out.println("Amount node in server is  " + serverOptional.get().getAmountOfNode());
//            serverOptional.get().setOptionalListOfNode(serverOptional.get().formNodeForServer());
//
//        }
//
//        //System.out.println(cluster.getOptionalListForServer().get(0).get().getOptionalListOfNode().get(0).get().getNumber());
//
//        System.out.println();System.out.println();


//        for (Optional<Server> serverOptional : cluster.getOptionalListForServer()) {
//
//            System.out.println();
//
//            System.out.println("server number - " + serverOptional.get().getNumber() + " Amount of node is  " + serverOptional.get().getOptionalListOfNode().size());
//
//            for (Optional<Node> nodeOptional : serverOptional.get().getOptionalListOfNode()){
//
//                System.out.println("node number - " + nodeOptional.get().getNumber() + " status is " + nodeOptional.get().getStatus() + " and presents is " + nodeOptional.isPresent());
//
//            }
//        }

    }
}
