package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by nsolanki on 10/14/2017.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallingCodesDataEntity {

    int callingCodes;

    public CallingCodesDataEntity(){}

    public int getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(int callingCodes) {
        this.callingCodes = callingCodes;
    }
}
