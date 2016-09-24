package org.eclipse.paho.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by jim.stys on 9/24/16.
 */

public class MqttServiceManager implements ITaskerActionRunner {
    private static final String SERVICE_NAME = "org.eclipse.paho.android.service.MqttService";

    @Override
    public void runAction(Context context, Bundle data) {
        String action = data.getString("action", null);
        switch(action){
            case "startService":
                Intent serviceStartIntent = new Intent();
                serviceStartIntent.setClassName(context, SERVICE_NAME);
                context.startService(serviceStartIntent);
                break;
            case "stopService":
                Intent stopServiceIntent = new Intent();
                stopServiceIntent.setClassName(context, SERVICE_NAME);
                context.stopService(stopServiceIntent);
                break;
            default:
                break;
        }
        //TODO: Send result to tasker

    }
}