package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by nsolanki on 10/14/2017.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLngDataEntity {

    float cordinate;

    public float getCordinate() {
        return cordinate;
    }

    public void setCordinate(float cordinate) {
        this.cordinate = cordinate;
    }
}
