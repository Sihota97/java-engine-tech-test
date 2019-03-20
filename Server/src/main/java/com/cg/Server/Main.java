package com.cg.Server;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        serve();
    }

    public static void serve() {
        port(8008);
        post("/serve", (req, res) -> {
                switch(req.body()) {
                    case "Hello":
                        return hello();
                    //other scenarios could go here ;)
                    default:
                        return "Error! No or invalid request name specified! (" + req.body() + ")";
                }
            }
        );
    }

    public static String hello() {
        return "Hello stranger!";
    }
}
