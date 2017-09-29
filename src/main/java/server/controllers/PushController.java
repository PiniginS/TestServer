package server.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

@Controller
public class PushController {

    @RequestMapping(value = "/push", method = RequestMethod.GET)
    @ResponseBody
    public void push(@RequestParam(value = "title", required = false, defaultValue = "") String title,
                     @RequestParam(value = "message", required = false, defaultValue = "") String message,
                     @RequestParam(value = "message", required = false, defaultValue = "") String id) throws IOException {

        String url = "https://fcm.googleapis.com/fcm/send";
        URL object = new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Authorization", "key=AAAAvVlHurs:APA91bFA2UOst5c_pisd9P7avMsgi5FewPUC0pfhduW8Lt5oxRf5SsXWfXEW1IdjHM23BKTK_BVhUnHEZ9j0kyXLvan4WZ2GQ_huxfrzLu2GSTHsZUhHWIQbd9KOvXbmYR026p2WdwFc");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestMethod("POST");

        JSONObject body = new JSONObject();
        if (id.length()>0) body.put("to",id);

        JSONObject data = new JSONObject();
        data.put("title",title);
        data.put("body",message);
        body.put("data",data);

        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
        wr.write(body.toString());
        wr.flush();

//display what returns the POST request

        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }
    }
}
