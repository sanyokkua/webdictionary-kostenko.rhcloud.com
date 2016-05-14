package com.kostenko.webmydictionary.translators.yandex;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kostenko.webmydictionary.translators.TranslatorAPI;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service("translatorAPI")
public class YandexAPI implements TranslatorAPI<String> {
    private static final Logger LOG = LoggerFactory.getLogger(YandexAPI.class);
    private final String API_KEY_ONE = "trnsl.1.1.20150522T195930Z.010ab143cb4576f2.568a0965d1a708e331f7af72fc325e30861ff083";
    private final String API_KEY_TWO = "trnsl.1.1.20150609T180905Z.f13a08e37aa237d0.1d49c5f38dcf5917e5e41950eb2882b27a3b97c8";
    private final String API_KEY_THREE = "trnsl.1.1.20160512T204421Z.b829b32f4cea989b.3fb210f3bcb6f16c61e92b993ed9d99a5fb9e561";
    /*https://translate.yandex.net/api/v1.5/tr.json/translate?key=<API-key>&text=<text>&lang=<direction like en-ru>&[format=<plain or html>]**/
    private final String URL_LINK = "https://translate.yandex.net/api/v1.5/tr.json/translate";//?key=$s&text=$s&lang=$s-$s&format=plain";

    @Override
    public String translate(String from, String to, String message) {
        String result = "";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(URL_LINK);
        httpPost.setHeader("User-Agent", "Mozilla/5.0");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("key", API_KEY_ONE));
        params.add(new BasicNameValuePair("lang", String.format("%1$s-%2$s", from, to)));
        params.add(new BasicNameValuePair("text", message));
        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        HttpResponse httpResponse;
        try {
            httpResponse = client.execute(httpPost);
            BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.readValue(br.readLine(), Object.class).toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}