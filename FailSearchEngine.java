public class FailSearchEngine implements FailSearchEngineInterface {

    private Cluster cluster;

    public FailSearchEngine(Cluster cluster) {
        this.cluster = cluster;
    }


    public void search(){

        for (int i=0; i<cluster.servers.size(); i++) {

            int firstIndex=0;
            int lastIndex = cluster.servers.get(i).getNodes().size();

            while (firstIndex <= lastIndex ) {


                if (cluster.isFailed(i, 0) == true) {System.out.println("server number  " + i + " node number " + 0 + " is fail"); return; }

                if (cluster.isFailed(i, cluster.servers.get(i).getNodes().size()-1) == false ) break;

                if ((cluster.isFailed(i, 0) == false ) & ((cluster.isFailed(i, 1) == true ))) {

                  System.out.println("server number  " + i + " node number " + 1 + " is fail"); break;}

                int middleIndex = (firstIndex + lastIndex) / 2;

                if ((cluster.isFailed(i, middleIndex) == true) & ((cluster.isFailed(i, middleIndex - 1) == false))) {

                    System.out.println("server number  " + i + " node number " + middleIndex + " is fail");

                    return;

                } else if ((cluster.isFailed(i, middleIndex) == true) & ((cluster.isFailed(i, middleIndex - 1) == true))) {


                    lastIndex = middleIndex - 1  ;

                } else if ((cluster.isFailed(i, middleIndex) == false) & ((cluster.isFailed(i, middleIndex - 1) == false))) {


                    firstIndex = middleIndex + 1 ;

                }

            }

        }
    }

}
