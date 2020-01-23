package ru.avalon.java.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * Упражнение, направленное на выработку умений, связанных
 * с отправкой сообщений средствами протокола UDP.
 *
 * @author Daniel Alpatov
 */
public final class UdpSender {

    public static void main(String[] args) throws IOException {
        // 1. Формируем сообщение
        final String message = prepareMessage();
        // 2. Формируем адрес конечной точки.
        final SocketAddress address = prepareAddress();
        // 3. Формируем датаграмму.
        final DatagramPacket packet = pack(message);
        // 4. Устанавливаем адрес для пакета.
        packet.setSocketAddress(address);
        // 5. Создаём сокет
        DatagramSocket socket = createSocket();
        // 6. Отправляем сообщение
        socket.send(packet);
        // 7. Освобождаем ресурсы
        socket.close();
    }
    /**
     * Возвращает сообщение.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() {
        /*
         * TODO Реализовать метод prepareMessage класса UdpSender
         */
        return "Hello over UDP protocol!";
        //throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Возвращает адрес конечной точки взаимодействия.
     *
     * @return адрес конечной точки.
     */
    private static SocketAddress prepareAddress() {
        /*
         * TODO Реализовать метод prepareAddress класса UdpSender
         */
        return new InetSocketAddress("localhost", 8080);
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает сокет, описывающий взаимодействие по протоколу UDP.
     *
     * @return сокет.
     * @throws IOException
     */
    private static DatagramSocket createSocket() throws IOException {
        /*
         * TODO Реализовать метод createSocket класса UdpSender
         */
        return new DatagramSocket();
        //throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Упаковывает текстовое сообщение в объект типа {@link DatagramPacket}.
     *
     * @param message строковое сообщение.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket pack(String message) throws UnsupportedEncodingException {
        /*
         * TODO Реализовать метод pack класса UdpSender
         */
        byte[] datagram = message.getBytes("UTF-8");
        return new DatagramPacket(datagram, datagram.length);
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
}
