package com.tesobe.obp.schedule;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Value("${chatfuel.url}")
    private String chatfuelUrl;
    
    @Value("${chatfuel.token}")
    private String chatfuelToken;
    
    @Value("${chatfuel.userId}")
    private String chatfuelUserId;
    
    @Value("${chatfuel.botId}")
    private String chatfuelBotId;

    @Scheduled(fixedRate = 10 * 1000)
    public void reportCurrentTime() {
        switch ((int) (Math.random() * 3)) {
        case 0:
            pushBotPay();
            break;
        case 1:
            pushBotAlertVirement();
            break;
        case 2:
            pushBotSeuilCC();
            break;
        }
    }

    private void pushBotPay() {
        double pay = 3600 + Math.random() * 2 * 100;
        pushBot("notif_pay", new ParameterPay(pay));
    }

    private void pushBotAlertVirement() {
        double pay = 3600 + Math.random() * 2 * 100;
        pushBot("notif_pay", new ParameterPay(pay));
    }

    private void pushBotSeuilCC() {
        double pay = 3600 + Math.random() * 2 * 100;
        pushBot("notif_pay", new ParameterPay(pay));
    }

    private class ParameterPay {
        private final double pay;

        public ParameterPay(double pay) {
            this.pay = pay;
        }
    }

    private void pushBot(String blocName, Object args) {
        String data = new Gson().toJson(args);
        String urlstr = String.format(chatfuelUrl, chatfuelBotId, chatfuelUserId, chatfuelToken, blocName);
        logger.debug("Send POST data to {}", urlstr);
        //chatfuel.url=https://api.chatfuel.com/bots/%s/users/%s/send?chatfuel_token=%s&chatfuel_block_name=%s

        byte[] postData = data.getBytes(StandardCharsets.UTF_8);
        try {
            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length));
            conn.setRequestMethod("POST");
            //Write POST data
            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.write(postData);
            }
            //Read reponse
            String resultContent = getResultContent(conn);
            logger.debug("Response {} ({}) :{}", conn.getResponseCode(), conn.getResponseMessage(), resultContent);
        } catch (IOException e) {
            logger.error("Can't do a POST", e);
        }
    }

    private String getResultContent(HttpURLConnection conn) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}