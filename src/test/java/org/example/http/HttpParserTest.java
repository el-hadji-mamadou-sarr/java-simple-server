package org.example.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {
    private  HttpParser httpParser;

    @BeforeAll
    public void beforeClass(){
        httpParser = new HttpParser();
    }
    @Test
    void parseHttpRequest() {
        httpParser.parseHttpRequest(
                generateValidTestCase()
        );
    }

    private InputStream generateValidTestCase(){
        String rawData="GET / HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Connection: keep-alive\r\n" +
                "Cache-Control: max-age=0\r\n" +
                "sec-ch-ua: \"Chromium\";v=\"124\", \"Brave\";v=\"124\", \"Not-A.Brand\";v=\"99\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8\r\n" +
                "Sec-GPC: 1\r\n" +
                "Accept-Language: fr-FR,fr\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br, zstd\r\n" +
                "Cookie: __client_uat=0; __clerk_db_jwt=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXYiOiJkdmJfMmJyQWlCdERWSTNKMkZ1ZUQ1NjZKdEJYbXJEIiwiaWQiOiJjbGllbnRfMmZCdlMxQnBhcmVyelFIM0ZJZXpHU1MwTG1zIiwicm90YXRpbmdfdG9rZW4iOiJiOWV5NDlwbjh6MDFycTQ3dDFtbHliNDBhNXFyYWQ5ZHZvc2oyYjdqIn0.UkccIchHQXqDIYgpMCwQfPGEEdhTmEXrFtqbMso4sqBw2hwoyJB3DmVn_JFpzWavHYJyClcs5G8xYMLE_Yl-1p6E0mobvqFzRlbmCm3IExGNxk-_V645F0HuIjyiYzswg2u7wP8RSb6WeHtQQaFORHo_J61eB-Dy6GWDpYGb0nkFgexQ1L44lrkVSHvJUZkdS-BR0sc1z8I80gbcMmjIP-JWuipRV0IOHElnuM2knog-dqJUZOqphi1gZis-vJx_Q_RSyLhyqdMxsqWiuHrGvKvcrvCnL9Wmh68Jm80_CK-hwFWZfkMSeztP7bmeGz9jsiSmDmWfpse0cBcwshbS2A\r\n"+
                "\r\n";

        return new ByteArrayInputStream(
                rawData.getBytes(StandardCharsets.US_ASCII)
        );

    }
}