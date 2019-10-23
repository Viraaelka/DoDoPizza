package com.config;


import com.config.annotations.PageEntry;
import com.main.exceptions.AutotestError;
import com.main.exceptions.PageInitializationException;
import com.google.common.reflect.ClassPath;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class PageWrapper {

    private String currentPageTitle;
    private Page currentPage;
    private final String pagesPackage;

    /**
     * @param pagesPackage a {@Link java.lang.String} object
     */
    public PageWrapper(String pagesPackage) {
        this.pagesPackage = pagesPackage;
    }

    public Page getPage(String title) throws PageInitializationException {
        if (null == currentPage || !currentPageTitle.equals(title)) {
            if (null != currentPage) {
                currentPage = getPage(currentPage.getClass().getPackage().getName(), title);
            }
            if (null == currentPage) {
                currentPage = getPage(pagesPackage, title);
            }
            if (null == currentPage) {
                throw new AutotestError("Page object with title '" + title + "' is not registered");
            }
        }
        return null;
    }

    /**
     * @param packageName a {@Link java.lang.String} object
     * @param title       a {@Link java.lang.String} object
     * @return a Page object
     * @throws PageInitializationException (@inheritDot)
     */
    public Page getPage(String packageName, String title) throws PageInitializationException {
        return bootstrapPage(getPageClass(packageName, title));
    }

    private Page bootstrapPage(Class<?> page) throws PageInitializationException {
        if (page != null) {
            try {
                Constructor<Page> constructor = ((Constructor<Page>) page.getConstructor());
                constructor.setAccessible(true);
                currentPage = constructor.newInstance();
                currentPageTitle = currentPage.getTitle();
                return currentPage;
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new PageInitializationException("Failed to initialize page '" + page + "'", e);
            }
        }
        return null;
    }

    private Class<?> getPageClass(final String packageName, String title) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final Set<Class<?>> allClassess = new HashSet<>();
        try {
            for (ClassPath.ClassInfo info : ClassPath.from(loader).getAllClasses()) {
                if (info.getName().startsWith(packageName + ".")) {
                    allClassess.add(info.load());
                }
            }
        } catch (IOException ex) {
            System.out.println("LOG.warn(Failed to shape class info set, ex)");
        }
        for (Class<?> page : allClassess) {
            String pageTitle = null;
            if (null != page.getAnnotation(PageEntry.class)) {
                pageTitle = page.getAnnotation(PageEntry.class).title();
            } else {
                try {
                    pageTitle = (String) FieldUtils.readStaticField(page, "title", true);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    System.out.println("LOG.debug(Failed to read pageTitle because it is not page object");
                }
            }
            if (pageTitle != null && pageTitle.equals(title)) {
                return page;
            }
        }
        return null;
    }

    public Page getCurrentPage() throws PageInitializationException {
        if (null == currentPage) {
            throw new PageInitializationException("Current page has been not initialized");
        } else {
            return currentPage;
        }
    }
    public String getCurrentPageTitle(){
        return currentPageTitle;
    }

}
