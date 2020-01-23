package ru.avalon.java.tcp;

import java.io.*;
import java.net.*;

/**
 * Упражнение на выработку базовых умений использования
 * протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpSender {

    public static void main(String[] args) throws IOException {
        // 1. Подготавливааем сообщение
        final String message = prepareMessage();
        // 2. Подготавливаем адрес
        final SocketAddress address = prepareAddress();
        // 3. Устанавливаем соединение
        Socket socket = connect(address);
        // 4. Отправляем сообщение
        send(socket, message);
        // 5. Закрываем соединеие
        socket.close();
    }
    /**
     * Возвращает объект сообщения.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса TcpSender
         */
        String message = "Hello over TCP protocol";
        return message;

        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает адрес, на который будет выполнена отправка сообщения.
     *
     * @return экземпля типа {@link SocketAddress}
     */
    private static SocketAddress prepareAddress() throws UnknownHostException {
        /*
         * TODO Реализовать метод prepareAddress класса TcpSender
         */
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        return address;

        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Устанавливает соединение на указанный адрес и возвращает сокет
     * описывающий соединение.
     *
     * @param address адрес, на который будет выполено соединение.
     *
     * @return сокет, описывающий открытое соединеие.
     *
     * @throws IOException
     */
    private static Socket connect(SocketAddress address) throws IOException {
        /*
         * TODO Реализовать метод connect класса TcpSender
         */
        Socket socket = new Socket();
        socket.connect(address);
        return socket;

        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Выполняет отправку сообщения {@code message} на {@code socket}.
     *
     * @param socket соединение, через которое будет отправлено сообщение.
     * @param message сообщение
     *
     * @throws IOException
     */
    private static void send(Socket socket, String message) {
        /*
         * TODO Реализовать метод send класса TcpSender
         */
        try {
            OutputStream stream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(stream);
            writer.println(message);
            writer.flush();
        }
        catch (IOException e ){
            System.out.println("Socket OutputStream error");
        }

        try {
            InputStream stream = socket.getInputStream();
            Reader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            System.out.println(line);
        }
        catch (IOException e ){
            System.out.println("Socket InputStream error");
        }
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
}
