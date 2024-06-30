package org.example;

import lombok.Getter;

import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class SiteMap {

    private final String url;

    private final CopyOnWriteArrayList<SiteMap>siteMapChildrens;
    public SiteMap(String url) {

        this.url = url;

        siteMapChildrens = new CopyOnWriteArrayList<>();

    }

    public void addChildren(SiteMap children)
    {

        siteMapChildrens.add(children);
    }




}
