package search;

import servers.Cluster;

public class FailSearchEngine {

    private Cluster cluster;

    public FailSearchEngine(Cluster cluster) {
        this.cluster = cluster;
    }


    public void search(){

        for (int i=0; i<cluster.getOptionalListForServer().size(); i++) {

            int firstIndex=0;
            int lastIndex = cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().size()-1; //servers.get(i).getNodes().size();

            while (firstIndex <= lastIndex ) {


                if (cluster.isFailed(i, 0) == true) {System.out.println("server number  " + /*i*/cluster.getOptionalListForServer().get(i).get().getNumber() + " node number " + 0 + " is fail"); return; }

                if (cluster.isFailed(i, cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().size()-1) == false ) break;

                if ((cluster.isFailed(i, 0) == false ) & ((cluster.isFailed(i, 1) == true ))) {

                    System.out.println("server number  " + /*i*/ + cluster.getOptionalListForServer().get(i).get().getNumber()+ " node number " + /*1*/cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().get(1).get().getNumber() + " is fail"); return;}

                int middleIndex = (firstIndex + lastIndex) / 2;

                if ((cluster.isFailed(i, middleIndex) == true) & ((cluster.isFailed(i, middleIndex - 1) == false))) {

                    System.out.println("server number  " + /*i*/cluster.getOptionalListForServer().get(i).get().getNumber() + " node number " + /*middleIndex*/ +cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().get(middleIndex).get().getNumber()+ " is fail");

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

