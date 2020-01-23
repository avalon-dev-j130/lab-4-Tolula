package ru.avalon.java.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Упражнение на выаботку умений связанных с получением сообщений,
 * отправленных с использованием протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpReceiver {

    public static void main(String[] args) throws IOException {
        // 1. Определяем порт, на котором ожидается соединение.
        final int port = 8080;
        // 2. Подготавливаем серверный сокет.
        final ServerSocket listener = prepareServerSocket();
        // 3. Принимаем соединение.
        Socket socket = listener.accept();
        // 4. Полоучаем сообщение.
        final String message = receive(socket);
        // 5. Закрываем соединение.
        socket.close();
        // 6. Закрываем серверный сокет.
        listener.close();
    }
    /**
     * Возвращает серверный сокет, связанный с портом, описанным
     * параметром {@code port}.
     *
     * @return серверный сокет, связанный с портом {@code port}.
     */
    private static ServerSocket prepareServerSocket() throws IOException {
        /*
         * TODO Реализовать метод prepareServerSocket класса TcpReceiver
         */
                return new ServerSocket(8080);

        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает сообщение, прочитанное из входящего потока,
     * указанного сокета.
     *
     * @param socket сокет, описывающий сетевое соединение.
     *
     * @return строковое сообщение.
     */
    private static String receive(Socket socket) throws IOException {
        /*
         * TODO Реализовать метод receive класса TcpReceiver
         */
        String line = "";
        try {
        InputStream stream = socket.getInputStream();
            Reader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();
            System.out.println(line);
        }
        catch (IOException e ){
        System.out.println("Socket InputStream error");
         }
        String message = "Hi Receiver";
        try {
            OutputStream stream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(stream);
            writer.println(message);
            writer.flush();
        }
        catch (IOException e ){
            System.out.println("Socket InputStream error");
        }
        return line;
    }
        //throw new UnsupportedOperationException("Not implemented yet!");
}
