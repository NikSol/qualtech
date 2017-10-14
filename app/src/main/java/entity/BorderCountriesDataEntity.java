package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by nsolanki on 10/14/2017.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorderCountriesDataEntity {

    public String borderCountry;

    public String getBorderCountry() {
        return borderCountry;
    }

    public void setBorderCountry(String borderCountry) {
        this.borderCountry = borderCountry;
    }
}
