package com.cg.Client;

import com.cg.Client.Client;
import org.junit.Test;

public class CommunicationTest { 

    @Test
    public void testHelloRequestCorrect() throws Exception {
        String res = Client.postRequest("Hello");
        assert (res.equals("Hello stranger!"));
    }

    @Test
    public void testHelloRequestIncorrect() throws Exception {
        String res = Client.postRequest("hello");
        assert (res.equals("Error! No or invalid request name specified! (hello)"));
    }

    //add more tests here to validate your work
}
