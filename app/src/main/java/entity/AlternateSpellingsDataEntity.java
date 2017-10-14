package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by nsolanki on 10/14/2017.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternateSpellingsDataEntity {

    String alternateSpellings;

    public String getAlternateSpellings() {
        return alternateSpellings;
    }

    public void setAlternateSpellings(String alternateSpellings) {
        this.alternateSpellings = alternateSpellings;
    }
}
