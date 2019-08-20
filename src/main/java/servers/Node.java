package servers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.FileWriter;
import java.io.IOException;


public class Node {
    @SerializedName("numberNode")
    private int number;
    private boolean status;


    public Node(int number, boolean status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", status=" + status +
                '}';
    }

    public void toJson() throws IOException {

        FileWriter fileWriter = new FileWriter("test.log");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        gson.toJson(this, fileWriter);

        fileWriter.flush();

        fileWriter.close();



    }
}

