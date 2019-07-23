public interface ClusterInterface {

    public void sendMessage();
    boolean isFailed(int serverNumber, int nodeNumber);
}
