package com.example.responsewrapperdemo.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Изначальная модель данных <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@Data
@AllArgsConstructor
public class MainModel {
    private String name;
    private String surname;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("surname", surname)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, surname);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MainModel that = (MainModel) obj;
        return Objects.equal(this.name, that.name)
                && Objects.equal(this.surname, that.surname);
    }
}
