package com.example.handsomemark.simpletalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    private ListView messageListView;
    private EditText inputText,outputText;
    private Button send,receive;
    private MessageAdapter messageAdapter;
    private List<Message> messagesList = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_page);
        messageAdapter = new MessageAdapter(HomePage.this,R.layout.message_item, messagesList);
        inputText = (EditText) findViewById(R.id.edit_text_sendmessage);
        outputText = (EditText) findViewById(R.id.edit_text_receivemessage);
        send = (Button) findViewById(R.id.button_send);
        receive = (Button) findViewById(R.id.button_receive);
        messageListView = (ListView) findViewById(R.id.list_view);
        messageListView.setAdapter(messageAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Message msg = new Message(content, Message.TYPE_SENT);
                    messagesList.add(msg);
                    inputText.setText("");
                    messageAdapter.notifyDataSetChanged();
                }
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = outputText.getText().toString();
                if (!"".equals(content)) {
                    Message msg = new Message(content, Message.TYPE_RECEIVED);
                    messagesList.add(msg);
                    outputText.setText("");
                    messageAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
