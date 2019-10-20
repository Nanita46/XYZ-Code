package com.xyzcode.xyzcode_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    /** Constantes para sensores */
    private static final float SHAKE_THRESHOLD = 1.1f;
    private static final int SHAKE_WAIT_TIME_MS = 250;
    private static final float ROTATION_THRESHOLD = 2.0f;
    private static final int ROTATION_WAIT_TIME_MS = 100;


    /** Sensores */
    private SensorManager mSensorManager;
    private Sensor mSensorAcc;
    private Sensor mSensorGyr;
    private long mShakeTime = 0;
    private long mRotationTime = 0;


    private TextView mGyrox;
    private TextView mGyroy;
    private TextView mGyroz;
    private TextView mAccx;
    private TextView mAccy;
    private TextView mAccz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Los sensores a usar
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorAcc = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorGyr = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);


        mGyrox = (TextView) findViewById(R.id.gyro_x);
        mGyroy = (TextView) findViewById(R.id.gyro_y);
        mGyroz = (TextView) findViewById(R.id.gyro_z);
        mAccx = (TextView) findViewById(R.id.accele_x);
        mAccy = (TextView) findViewById(R.id.accele_y);
        mAccz = (TextView) findViewById(R.id.accele_z);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorAcc, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mSensorGyr, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {

            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                //mAccx.setText(R.string.act_main_no_acuracy);
                //mAccy.setText(R.string.act_main_no_acuracy);
                //mAccz.setText(R.string.act_main_no_acuracy);
                mAccx.setText("fadgdsfasd");
                mAccy.setText("sdfgadfdsfa");
                mAccz.setText("gfhdfghdf");
            } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                //mGyrox.setText(R.string.act_main_no_acuracy);
                //mGyroy.setText(R.string.act_main_no_acuracy);
                //mGyroz.setText(R.string.act_main_no_acuracy);
                mGyrox.setText("fadgdsfasd");
                mGyroy.setText("sdfgadfdsfa");
                mGyroy.setText("gfhdfghdf");
            }
            return;
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mAccx.setText("acelerador x = " + Float.toString(event.values[0]));
            mAccy.setText("acelerador y = " + Float.toString(event.values[1]));
            mAccz.setText("acelerador z = " + Float.toString(event.values[2]));
            detectShake(event);
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            mGyrox.setText("giroscopio x = " + Float.toString(event.values[0]));
            mGyroy.setText("giroscopio y = " + Float.toString(event.values[1]));
            mGyroz.setText("giroscopio z = " + Float.toString(event.values[2]));
            detectRotation(event);
        }

    }

    /**
     * Deteccion de movimiento basada en acelerometro *
     * @param event
     */
    private void detectShake(SensorEvent event) {
        long now = System.currentTimeMillis();

        if ((now - mShakeTime) > SHAKE_WAIT_TIME_MS) {
            mShakeTime = now;

            float gX = event.values[0] / SensorManager.GRAVITY_EARTH;
            float gY = event.values[1] / SensorManager.GRAVITY_EARTH;
            float gZ = event.values[2] / SensorManager.GRAVITY_EARTH;
            double gForce = Math.sqrt(gX * gX + gY * gY + gZ * gZ);
            if (gForce > SHAKE_THRESHOLD) {

            }
        }
    }

    /**
     * Deteccion de movimiento basada en giroscopio *
     * @param event
     */
    private void detectRotation(SensorEvent event) {
        long now = System.currentTimeMillis();

        if ((now - mRotationTime) > ROTATION_WAIT_TIME_MS) {
            mRotationTime = now;

            if (Math.abs(event.values[0]) > ROTATION_THRESHOLD ||
                    Math.abs(event.values[1]) > ROTATION_THRESHOLD ||
                    Math.abs(event.values[2]) > ROTATION_THRESHOLD) {

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}