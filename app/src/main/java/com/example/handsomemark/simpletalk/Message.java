package com.example.handsomemark.simpletalk;

/**
 * Created by handsomemark on 2016/3/17.
 */
public class Message {
    private String message;
    private int type;
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    public Message(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }
}
