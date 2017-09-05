package com.epam.logger;

import com.epam.entity.Event;

/**
 * Created by dmitry on 05.09.17.
 */
public class ConsoleEventLogger implements EventLogger{

    public void logEvent(Event event){
        System.out.println(event);
    }
}
