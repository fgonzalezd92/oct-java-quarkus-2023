package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class Door {
    @Inject
    @Named("silent")
    private Alarm alarm;

    public Alarm getAlarm() {
        return alarm;
    }
}

interface Alarm {}
@ApplicationScoped
//@Alternative
@Named("silent")
class SilentAlarm implements Alarm {}
@ApplicationScoped
@Named("loud")
//@Default
class LoudAlarm implements Alarm {}