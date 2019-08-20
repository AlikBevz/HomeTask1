package servers;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class NodeTest {



    @Test
    public void testToString(){
        Node node = new Node(0, true);

        String nodeToString = node.toString();

        System.out.println(nodeToString);

        assertThat(nodeToString, containsString("Node"));
        assertThat(nodeToString, containsString("number"));
        assertThat(nodeToString, containsString("status"));


    }

    @Test
    public void testNodeToJson() throws IOException {

        Node node = new Node(0, true);
        node.toJson();

    }

}