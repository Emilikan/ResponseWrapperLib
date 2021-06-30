package com.example.responsewrapperdemo.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.emilnasyrov.lib.response.wrapper.IWrapperModel;

/**
 * Модель-обертка <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wrapper implements IWrapperModel {
    @JsonUnwrapped
    Object main;

    String someInfo;

    @Override
    public void setData(Object object) {
        someInfo = object.toString();
    }

    @Override
    public void setBody(Object object) {
        main = object;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("main", main)
                .add("someInfo", someInfo)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(main, someInfo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Wrapper that = (Wrapper) obj;
        return Objects.equal(this.main, that.main)
                && Objects.equal(this.someInfo, that.someInfo);
    }
}
