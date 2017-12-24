package com.example.tee.mylabservices;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.tee.mylabservices.action.FOO";
    private static final String ACTION_BAZ = "com.example.tee.mylabservices.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.tee.mylabservices.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.tee.mylabservices.extra.PARAM2";
    private static final String TAG = "MTAG";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

            int limit = intent.getIntExtra("limit",0);
            for (int i = 0; i <=limit ; i++) {

                int percentage = (i*100)/limit;

                try {
                    Thread.sleep(1000);
                    Event event = new Event(percentage);
                    EventBus.getDefault().post(event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }

    @Override
    public void onDestroy() {
        stopSelf();
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
