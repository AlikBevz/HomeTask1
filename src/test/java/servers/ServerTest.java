package servers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class ServerTest {




    private static final Random RANDOM = new Random();

    private int amountOfNodeInServer = RANDOM.nextInt(10);



    @Test
    public void testServerToJson() throws IOException{

        System.out.println("Amount of Node is - " + amountOfNodeInServer);

        Server server = new Server();


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("test.log");

        gson.toJson(server.formNodeForServer(), fileWriter);

        fileWriter.flush();

        fileWriter.close();




    }

}