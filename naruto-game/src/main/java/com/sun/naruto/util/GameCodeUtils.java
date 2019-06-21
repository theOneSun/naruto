package com.sun.naruto.util;

import com.sun.naruto.exception.OutOfGameRoomException;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author sunjian.
 */
public class GameCodeUtils {

    private static ConcurrentLinkedQueue<String> gameCodePool;
    static {
        gameCodePool = new ConcurrentLinkedQueue<>();
        //默认100个房间
        for (int i=1;i<=100;i++){
            gameCodePool.add(String.valueOf(i));
        }
    }

    public static String generateCode(){
        final String code = gameCodePool.poll();
        if (null == code){
            throw new OutOfGameRoomException(OutOfGameRoomException.message);
        }
        return code;
    }

    /*public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            System.out.println(generateCode());
        }
        //        System.out.println(generateCode());
    }*/

    public static void recycleCode(String code){
        gameCodePool.add(code);
    }

}
