package com.razerpayment.plugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@CapacitorPlugin(name = "RazerPayment")
public class RazerPaymentPlugin extends Plugin {

    String MerchantHost, OpType, Currency, Amount, OrderId, Channel, Tid, data_value;
    private RazerPayment implementation = new RazerPayment();
    private static RazerPaymentPlugin instance;

    public static RazerPaymentPlugin getInstance() {
        return instance;
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        Log.e("6666666666666666",value);
    }

    @PluginMethod
    public void status(PluginCall call) {
        Log.e("999999999999", "Working Share Perferance");
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("READ_DATA", getContext().MODE_PRIVATE);
        MerchantHost = sharedPreferences.getString("MerchantHost", "");
        OpType = sharedPreferences.getString("OpType", "");
        Currency = sharedPreferences.getString("Currency", "");
        Amount = sharedPreferences.getString("Amount", "");
        OrderId = sharedPreferences.getString("OrderId", "");
        Channel = sharedPreferences.getString("Channel", "");
        Tid = sharedPreferences.getString("Tid", "");
        data_value = sharedPreferences.getString("dataValue", "");
        if (!TextUtils.isEmpty(data_value)) {
            // data_value is not empty
            Log.e("999999999999", "data_value is not empty");
            JSObject result = new JSObject();
            result.put("status", "success");
            result.put("MerchantHost", MerchantHost);
            result.put("OpType", OpType);
            result.put("Currency", Currency);
            result.put("Amount", Amount);
            result.put("OrderId", OrderId);
            result.put("Channel", Channel);
            result.put("Tid", Tid);
            result.put("data_value", data_value);
            call.success(result);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
        }

    }

    @PluginMethod
    public void start(PluginCall call) {
        try {
            // Assuming 'value' is your JSON string
            String value = call.getString("value");
            Log.e("6666666666666666", value);

            // Parse the JSON string
            JSONArray jsonArray = new JSONArray(value);

            // Extract the first object from the array
            JSONObject json = jsonArray.getJSONObject(0);

            // Extract the 'Amount' field as an integer
            String merchanthost = json.getString("MerchantHost");
            String optype = json.getString("OpType");
            String currency = json.getString("Currency");
            String amount = json.getString("Amount");
            String orderid = json.getString("OrderId");
            String channel = json.getString("Channel");
            String Tid = json.getString("Tid");
            if (amount.isEmpty()) {
                Toast.makeText(getContext(), "Please enter the amount", Toast.LENGTH_SHORT).show();
            }else {
                String packageName = "com.rzr.pay";
                String className = "com.rzr.pay.MainActivity";
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(packageName, className));
                intent.putExtra("MerchantHost", merchanthost);
                intent.putExtra("OpType", optype);
                intent.putExtra("Currency", currency);
                intent.putExtra("Amount", amount);
                intent.putExtra("OrderId", orderid);
                intent.putExtra("Channel", channel);
                intent.putExtra("Tid", Tid);
                intent.putExtra("Log","NA");
                PackageManager packageManager = getContext().getPackageManager();
                if (intent.resolveActivity(packageManager) != null) {
                    getContext().startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Please install supported app", Toast.LENGTH_SHORT).show();
                }
            }

        } catch (JSONException e) {
            // Handle JSON parsing exception
            Log.e("ERROR", "JSONException: " + e.getMessage());
            e.printStackTrace();
        }
    }







}

