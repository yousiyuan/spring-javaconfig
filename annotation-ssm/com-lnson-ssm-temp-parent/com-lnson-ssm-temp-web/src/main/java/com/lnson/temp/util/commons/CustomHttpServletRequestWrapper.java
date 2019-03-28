package com.lnson.temp.util.commons;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * 所有的post请求中的body参数是已流形式存在的，而流数据只能读取一次，因此，我们读取了inputStream之后，记得再将数据写回去
 */
public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private byte[] body;

    private BufferedReader reader;

    private ServletInputStream inputStream;

    public CustomHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        loadBody(request);
    }

    private void loadBody(HttpServletRequest request) throws IOException {
        body = IOUtils.toByteArray(request.getInputStream());
        inputStream = new RequestCachingInputStream(body);
    }

    public byte[] getBody() {
        return body;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (inputStream != null) {
            return inputStream;
        }
        return super.getInputStream();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(inputStream, getCharacterEncoding()));
        }
        return reader;
    }

    public String getRequestContent(byte[] buf, String characterEncoding) {
        String payload = new String();
        if (buf == null) return payload;
        if (buf.length > 0) {
            int length = Math.min(buf.length, 1024);
            try {
                payload = new String(buf, 0, length, characterEncoding);
            } catch (UnsupportedEncodingException ex) {
                payload = "[unknown]";
            }
        }
        return payload;
    }

    private static class RequestCachingInputStream extends ServletInputStream {

        private final ByteArrayInputStream inputStream;

        public RequestCachingInputStream(byte[] bytes) {
            inputStream = new ByteArrayInputStream(bytes);
        }

        @Override
        public int read() throws IOException {
            return inputStream.read();
        }

        @Override
        public boolean isFinished() {
            return inputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readlistener) {
        }

    }
}
