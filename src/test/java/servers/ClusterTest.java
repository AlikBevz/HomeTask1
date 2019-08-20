package servers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ClusterTest {



    @Test
    public void testClusterToJson() throws IOException {

        Cluster cluster = new Cluster();

        cluster.setOptionalListForServer(cluster.formedServerForCluster());

        cluster.formedNodeForServersInCluster();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("test.log");

        gson.toJson(cluster, fileWriter);

        fileWriter.flush();

        fileWriter.close();




    }

}