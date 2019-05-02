package com.pivotenergy.model.location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** A Plus Code encoded location reference. */
@Getter
@Setter
@NoArgsConstructor
public class PlusCode {
    /** The global Plus Code identifier. */
    public String globalCode;

    /** The compound Plus Code identifier. May be null for locations in remote areas. */
    public String compoundCode;

    public String toString() {
        StringBuilder sb = new StringBuilder("[PlusCode: ");
        sb.append(globalCode);
        if (compoundCode != null) {
            sb.append(", compoundCode=").append(compoundCode);
        }
        sb.append("]");
        return sb.toString();
    }
}
