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
            int lastIndex = cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().size()-1;

            while (firstIndex <= lastIndex ) {


                if (cluster.isFailed(i, 0)){System.out.println("server number  " + cluster.getOptionalListForServer().get(i).get().getNumber() + " node number " + cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().get(0).get().getNumber() + " is fail"); return; }

                if (!cluster.isFailed(i, cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().size()-1) ) break;

                if (!(cluster.isFailed(i, 0)) & ((cluster.isFailed(i, 1) ))) {

                    System.out.println("server number  " +  + cluster.getOptionalListForServer().get(i).get().getNumber()+ " node number " + cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().get(1).get().getNumber() + " is fail"); return;}

                int middleIndex = (firstIndex + lastIndex) / 2;

                if ((cluster.isFailed(i, middleIndex)) & (!(cluster.isFailed(i, middleIndex - 1)))) {

                    System.out.println("server number  " + cluster.getOptionalListForServer().get(i).get().getNumber() + " node number " + /*middleIndex*/ +cluster.getOptionalListForServer().get(i).get().getOptionalListOfNode().get(middleIndex).get().getNumber()+ " is fail");

                    return;

                } else if ((cluster.isFailed(i, middleIndex)) & ((cluster.isFailed(i, middleIndex - 1) ))) {


                    lastIndex = middleIndex - 1  ;

                } else if (!(cluster.isFailed(i, middleIndex)) & (!(cluster.isFailed(i, middleIndex - 1)))) {


                    firstIndex = middleIndex + 1 ;

                }

            }

        }
    }

}

