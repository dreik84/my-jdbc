package org.example.util;

import lombok.experimental.UtilityClass;

//@UtilityClass
public final class JspHelper {
    private final static String JSP_FORMAT = "/WEB-INF/jsp/%s.jsp";

    public static String getPath(String jsp) {
        return JSP_FORMAT.formatted(jsp);
    }

    private JspHelper() {
    }
}
