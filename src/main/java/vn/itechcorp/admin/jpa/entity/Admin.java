package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.persistence.model.BaseDbEntry;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_admin")
@Getter
@Setter
public class Admin extends BaseDbEntry<Long> {
    private String username;
    private String password;
}
