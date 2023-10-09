package view;

import model.Model;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;


public class WebViewServer extends WebSocketServer implements View, ModelObserver {
    private static final int PORT = 3000;
    private final Model model;

    public WebViewServer(Model model) {
        super(new InetSocketAddress(PORT));
        this.model = model;
        this.model.addObserver(this);
    }


    @Override
    public void notifyModelUpdated() {
        System.out.println("[WebView] sending new state to all the webSockets connected");
        this.broadcast(this.model.getState() + "");
    }

    @Override
    public void display() {
        this.start();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("new connection: " + handshake
                .getResourceDescriptor());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println(conn + " has disconnected!");
        conn.close();
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println(conn + ": " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("Server listening on port: " + PORT);
    }
}
