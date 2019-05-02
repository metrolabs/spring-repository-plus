package com.pivotenergy.domain.common;

import java.io.Serializable;

/**
 * Created by wgayton on 9/11/17.
 */
public class KeyValuePair implements Serializable {
    private String key;
    private Object value;

    public KeyValuePair() {
    }

    public KeyValuePair(Object key, Object value) {
        this.key = key.toString();
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public KeyValuePair setKey(String key) {
        this.key = key;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public KeyValuePair setValue(Object value) {
        this.value = value;
        return this;
    }
}
