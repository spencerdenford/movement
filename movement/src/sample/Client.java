package sample;

import javafx.application.Application;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner scan = new Scanner (System.in);
        Pane pane = new Pane();

        System.out.print("Enter username: ");
        String un = scan.next();
        String host = "localhost";
        int port = 20500;

        Socket socket = new Socket(host, port);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        System.out.println("Connected to " + host + " : " + port);

        // display
        Label label = new Label(un);
        pane.getChildren().addAll(label);
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the
        primaryStage.show(); // Display the stage..

        in.close();
        out.close();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}