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





    }
}
