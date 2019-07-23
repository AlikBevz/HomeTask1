import java.util.ArrayList;
import java.util.List;

public class ServerWithAraylist   {
    private int number;
    private List<Node> nodes ;

    public ServerWithAraylist(int number, List<Node> nodes) {
        this.number = number;
        this.nodes = nodes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }


    public void searchStatusForAllNode(){

        for (Node node : nodes){
            System.out.print("Server number - " + this.getNumber() + "  node number - " + node.getNumber() + "  status is - " + node.getStatus());
            System.out.println();
        }


    }


}
