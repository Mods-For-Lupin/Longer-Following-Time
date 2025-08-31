package com.cursee.longer_following_time.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Config {

  private Map<String, String> data = new HashMap<>();
  private String filePath;

  public Config(String filePath) {
    this.filePath = filePath;
    load();
  }

  public void load() {
    try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = r.readLine()) != null) {
        if (line.contains("=")) {
          String[] parts = line.split("=", 2);
          data.put(parts[0].trim(), parts[1].trim());
        }
      }
    } catch (IOException e) {
      // File doesn't exist or can't be read - start with empty config
    }
  }

  public void save() {
    try (PrintWriter w = new PrintWriter(new FileWriter(filePath))) {
      for (Map.Entry<String, String> entry : data.entrySet()) {
        w.println(entry.getKey() + "=" + entry.getValue());
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to save config", e);
    }
  }

  public void set(String key, String value) { data.put(key, value); }
  public void set(String key, int value) { data.put(key, String.valueOf(value)); }
  public void set(String key, boolean value) { data.put(key, String.valueOf(value)); }
  public void set(String key, float value) { data.put(key, String.valueOf(value)); }

  public String getString(String key, String defaultValue) {
    return data.getOrDefault(key, defaultValue);
  }

  public int getInt(String key, int defaultValue) {
    try {
      return Integer.parseInt(data.get(key));
    } catch (NumberFormatException | NullPointerException e) {
      return defaultValue;
    }
  }

  public boolean getBoolean(String key, boolean defaultValue) {
    String value = data.get(key);
    return value != null ? Boolean.parseBoolean(value) : defaultValue;
  }

  public float getFloat(String key, float defaultValue) {
    try {
      return Float.parseFloat(data.get(key));
    } catch (NumberFormatException | NullPointerException e) {
      return defaultValue;
    }
  }
}
