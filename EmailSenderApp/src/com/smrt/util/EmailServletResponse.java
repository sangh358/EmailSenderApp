package com.smrt.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class EmailServletResponse implements HttpServletResponse {

private int status;
private StringWriter sw = new StringWriter();

@Override
public void flushBuffer() throws IOException {
    sw.flush();
}

@Override
public int getBufferSize() {
    return 1024;
}

@Override
public String getCharacterEncoding() {
    return "UTF-8";
}

@Override
public String getContentType() {
    return "text/html";
}

@Override
public Locale getLocale() {
    return Locale.getDefault();
}

@Override
public ServletOutputStream getOutputStream() throws IOException {
    return new ServletOutputStream() {
        @Override
        public void write(int b) throws IOException {
            sw.write(b);
        }

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setWriteListener(WriteListener arg0) {
			// TODO Auto-generated method stub
			
		}
    };
}

@Override
public PrintWriter getWriter() throws IOException {
    PrintWriter pw = new PrintWriter(sw);
    return pw;
}

@Override
public boolean isCommitted() {
    return false;
}

@Override
public void reset() {       
}

@Override
public void resetBuffer() {
}

@Override
public void setBufferSize(int arg0) {
}

@Override
public void setCharacterEncoding(String arg0) {
}

@Override
public void setContentLength(int arg0) {
}

@Override
public void setContentType(String arg0) {
}

@Override
public void setLocale(Locale arg0) {
}

@Override
public void addCookie(Cookie arg0) {
}

@Override
public void addDateHeader(String arg0, long arg1) {
}

@Override
public void addHeader(String arg0, String arg1) {
}

@Override
public void addIntHeader(String arg0, int arg1) {
}

@Override
public boolean containsHeader(String arg0) {
    return false;
}

@Override
public String encodeRedirectURL(String arg0) {
    return "";
}

@Override
public String encodeRedirectUrl(String arg0) {
    return "";
}

@Override
public String encodeURL(String arg0) {
    return "";
}

@Override
public String encodeUrl(String arg0) {
    return "";
}

@Override
public void sendError(int arg0) throws IOException {

}

@Override
public void sendError(int arg0, String arg1) throws IOException {

}

@Override
public void sendRedirect(String arg0) throws IOException {

}

@Override
public void setDateHeader(String arg0, long arg1) {

}

@Override
public void setHeader(String arg0, String arg1) {


}

@Override
public void setIntHeader(String arg0, int arg1) {

}

@Override
public void setStatus(int status) {
    this.status = status;
}

@Override
public void setStatus(int status, String message) {
    setStatus(status);
}

public String toString(){
    return sw.getBuffer().toString();
}

@Override
public void setContentLengthLong(long arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public String getHeader(String arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<String> getHeaderNames() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Collection<String> getHeaders(String arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int getStatus() {
	// TODO Auto-generated method stub
	return 0;
}
}
