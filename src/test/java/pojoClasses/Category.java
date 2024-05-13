package pojoClasses;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
//import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnore;
//import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
//import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
//import io.qameta.allure.internal.shadowed.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
public class Category {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}