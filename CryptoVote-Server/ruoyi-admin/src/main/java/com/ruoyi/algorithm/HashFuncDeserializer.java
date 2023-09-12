package com.ruoyi.algorithm;

import com.google.gson.*;
import com.ruoyi.algorithm.hash.BKDRHash;
import com.ruoyi.algorithm.hash.HashFunc;
import com.ruoyi.algorithm.hash.RSHash;
import com.ruoyi.algorithm.hash.SDBMHash;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class HashFuncDeserializer implements JsonDeserializer<HashFunc> {
    private Gson gson = new Gson();
    private Map<String, Class<? extends HashFunc>> sonType = new HashMap<>();

    public HashFuncDeserializer() {
        sonType.put("BKDRHash", BKDRHash.class);
        sonType.put("SDBMHash", SDBMHash.class);
        sonType.put("RSHash", RSHash.class);
    }

    @Override
    public HashFunc deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Class<? extends HashFunc> clazz = this.sonType.get(jsonObject.get("className").getAsString());
        return gson.fromJson(jsonElement, clazz);
    }
}
