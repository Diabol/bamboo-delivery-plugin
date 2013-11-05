package se.diabol.bamboo.plugin.pipeline;

import com.atlassian.bamboo.ww2.BambooActionSupport;
import com.opensymphony.webwork.dispatcher.json.JSONArray;
import com.opensymphony.webwork.dispatcher.json.JSONException;
import com.opensymphony.webwork.dispatcher.json.JSONObject;
import org.jetbrains.annotations.NotNull;

public class PipelineWallboardAction extends BambooActionSupport {

    /**
     * Runs the action returning the HTML wallboard page.
     *
     * @return always success.
     */
    @Override
    public String doDefault() {
        return SUCCESS;
    }

    /**
     * Runs the action returning the Json wallboard page.
     *
     * @return always success.
     */
    @SuppressWarnings("unused")
    public String doJson() {
        return SUCCESS;
    }


    @SuppressWarnings("unused")
    public String getContext() {
        return getBambooUrl().rootContext();
    }

    @NotNull
    @Override
    public JSONObject getJsonObject() throws JSONException {
        JSONObject result = new JSONObject();
        result.append("pipelines", new JSONArray());
        return result;
    }
}
