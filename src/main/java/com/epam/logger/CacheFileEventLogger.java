package com.epam.logger;

import com.epam.entity.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 07.09.17.
 */
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;

    private List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
