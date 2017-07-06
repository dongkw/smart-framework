package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dkw on 2017/7/3.
 */
public class View {
    /**
     * 视图路径
     */
    private String path;
    /**
     * 模型数据
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, Object> getModel() {
        return this.model;
    }
}
