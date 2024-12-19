package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import errors.AplicationError;

public class Format {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String serialize(Object object) throws AplicationError {
    if (object == null) {
      return null;
    }
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new AplicationError("Erro ao serializar objeto para JSON: " + e.getMessage());
    }
  }

  public static <T> T deserialize(String jsonString, Class<T> valueType) throws AplicationError {
    if (jsonString == null || valueType == null) {
      return null;
    }
    try {
      return objectMapper.readValue(jsonString, valueType);
    } catch (JsonProcessingException e) {
      throw new AplicationError("Erro ao deserializar JSON para objeto: " + e.getMessage());
    }
  }
}
