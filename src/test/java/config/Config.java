package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();


    // Статическая инициализация: загружаем конфиг при первом обращении к классу
    static {
        try (InputStream input = ClassLoader.getSystemResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл config.properties не найден в classpath!");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке config.properties", e);
        }
    }

    // Метод для получения строкового значения
    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    // Метод для числовых значений (с дефолтом)
    public static int getIntProperty(String key, int defaultValue) {
        String value = props.getProperty(key);
        return value != null ? Integer.parseInt(value) : defaultValue;
    }

    // метод для получения базового урла
    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    // метод для получения урла с эндпоинтом
    public static String getPageUrl(String pageKey) {
        String base = getBaseUrl();
        String endpoint = props.getProperty(pageKey);
        if (endpoint == null || endpoint.isEmpty()) {
            throw new IllegalArgumentException("Эндпоинт для '" + pageKey + "' не найден в конфиге!");
        }
        return base + endpoint;
    }
}
