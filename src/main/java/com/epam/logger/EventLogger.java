package com.epam.logger;

import com.epam.entity.Event;

/**
 * Created by dmitry on 05.09.17.
 */
public interface EventLogger {

    void logEvent(Event event);
}
