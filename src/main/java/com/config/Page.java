package com.config;

import com.config.annotations.PageEntry;

public class Page {

    /**
     * Get title of current page object
     *
     * @return the title
     */
    public String getTitle() {
        return this.getClass().getAnnotation(PageEntry.class).title();
    }
}
