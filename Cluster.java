import java.util.List;

public class Cluster implements ClusterInterface {


    List<ServerWithAraylist> servers;

    public Cluster(List<ServerWithAraylist> servers) {
        this.servers = servers;
    }



    public void sendMessage() {



        int amountOfServer = servers.size();

        int RandomForServer = (int) ( Math.random() * amountOfServer );

        int amountOfNodeInServer = servers.get(RandomForServer).getNodes().size();

        int RandomForNode = (int) ( Math.random() * amountOfNodeInServer );

         for (int i = RandomForNode; i < amountOfNodeInServer; i++)

             servers.get(RandomForServer).getNodes().get(i).setStatus(true);

    }


    public boolean isFailed(int serverNumber, int nodeNumber){

        return servers.get(serverNumber).getNodes().get(nodeNumber).getStatus();




    }



    public void searchAllNodeInServers(){

        for (ServerWithAraylist server : servers){

            server.searchStatusForAllNode();
        }


    }



}