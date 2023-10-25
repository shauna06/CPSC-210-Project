package persistence;

import org.json.JSONObject;

// Code heavily influenced by the JsonSerializationDemo: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as a JSON object

    JSONObject toJson();
}
