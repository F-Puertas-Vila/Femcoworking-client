/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOCaltasques;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Xavi
 */
public class JsonParse {
    public boolean isJSONValid(String json) {

    try {

        new JSONObject(json);

    } catch (JSONException ex) {

        // edited, to include @Arthur's comment

        // e.g. in case JSONArray is valid as well...

        try {

            new JSONArray(json);

        } catch (JSONException ex1) {

            return false;

        }

    }

    return true;

}
}
