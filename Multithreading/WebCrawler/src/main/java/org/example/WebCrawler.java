package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveAction;
public class WebCrawler extends RecursiveAction {

    private SiteMap siteMap;
    private static final CopyOnWriteArrayList<String> linksVisited = new CopyOnWriteArrayList<>();

    public WebCrawler(SiteMap siteMap) {
        this.siteMap = siteMap;
    }

    @Override
    protected void compute() {

        linksVisited.add(siteMap.getUrl());

        ConcurrentSkipListSet<String> links = HtmlParser.getUrls(siteMap.getUrl());

        for (String perLink : links) {

            if (!linksVisited.contains(perLink)) {

                linksVisited.add(perLink);

                siteMap.addChildren(new SiteMap(perLink));

            }
        }

        List<WebCrawler> mapOfSiteTasks = new ArrayList<>();

        for (SiteMap child : siteMap.getSiteMapChildrens()) {

            WebCrawler webCrawlerTask = new WebCrawler(child);

            webCrawlerTask.fork();

            mapOfSiteTasks.add(webCrawlerTask);

        }

        for (WebCrawler perTask : mapOfSiteTasks) {

            perTask.join();

        }
    }
}