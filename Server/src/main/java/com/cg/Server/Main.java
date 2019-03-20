package com.cg.Server;

import static spark.Spark.port;
import static spark.Spark.post;

import com.cg.Server.Service.ProcessSpin;
import com.cg.Server.Service.ProcessWeightedNumber;

public class Main {

	public static String hello() {
		return "Hello";
	}

	public static void main(String[] args) {

		serve();
	}

	public static void serve() {
		port(8008);
		post("/serve", (req, res) -> {
			switch (req.body()) {
			case "Hello":
				return hello();
			case "Table":
				return ProcessWeightedNumber.getRandomValue();
			// other scenarios could go here ;)
			case "Spin":
				return ProcessSpin.getSpinMatrix();
			default:
				return "Error! No or invalid request name specified! (" + req.body() + ")";
			}
		});
	}

}
