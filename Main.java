import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        Node nodeFirstForFirstServer = new Node(0, false);
        Node nodeSecondForFirstServer = new Node(1, false);
        Node nodeThirdForFirstServer = new Node(2, false);

        List<Node> nodesForFirstServer= new ArrayList<>();

        nodesForFirstServer.add(nodeFirstForFirstServer);
        nodesForFirstServer.add(nodeSecondForFirstServer);
        nodesForFirstServer.add(nodeThirdForFirstServer);


        Node nodeFirstForSecondServer = new Node(0, false);
        Node nodeSecondForSecondServer = new Node(1, false);
        Node nodeThirdForSecondServer = new Node(2, false);
        Node nodeFourthForSecondServer = new Node(3, false);
        Node nodeFifthForSecondServer = new Node(4, false);


        List<Node> nodesForSecondServer= new ArrayList<>();

        nodesForSecondServer.add(nodeFirstForSecondServer);
        nodesForSecondServer.add(nodeSecondForSecondServer);
        nodesForSecondServer.add(nodeThirdForSecondServer);
        nodesForSecondServer.add(nodeFourthForSecondServer);
        nodesForSecondServer.add(nodeFifthForSecondServer);




        ServerWithAraylist serverFirstWithAraylist = new ServerWithAraylist(0, nodesForFirstServer);


        ServerWithAraylist serverSecondWithAraylist = new ServerWithAraylist(1, nodesForSecondServer);


        List<ServerWithAraylist> servers = new ArrayList<>();
        servers.add(serverFirstWithAraylist);
        servers.add(serverSecondWithAraylist);

        Cluster cluster = new Cluster(servers);

        FailSearchEngine failSearchEngine = new FailSearchEngine(cluster);


        cluster.sendMessage();

        cluster.searchAllNodeInServers();

        failSearchEngine.search();



    }
}
