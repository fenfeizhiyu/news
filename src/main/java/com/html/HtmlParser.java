package com.html;

import com.model.NewsTitle;

/**
 * @author yu.yang
 */
public interface HtmlParser {

    NewsTitle parserNewsTitle(String text);
}
