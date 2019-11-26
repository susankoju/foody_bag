/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist.bit.foodybag.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "events")
@XmlRootElement
@NamedQueries({
            @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e")
            , @NamedQuery(name = "Events.findById", query = "SELECT e FROM Events e WHERE e.id = :id")
            , @NamedQuery(name = "Events.findByTitle", query = "SELECT e FROM Events e WHERE e.title = :title")
            , @NamedQuery(name = "Events.findByTime", query = "SELECT e FROM Events e WHERE e.time = :time")})
public class Events implements Serializable {

            private static final long serialVersionUID = 1L;
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Basic(optional = false)
            @Column(name = "id")
            private Integer id;
            @Basic(optional = false)
            @Column(name = "title")
            private String title;
            @Basic(optional = false)
            @Lob
            @Column(name = "description")
            private String description;
            @Basic(optional = false)
            @Column(name = "time")
            @Temporal(TemporalType.TIMESTAMP)
            private Date time;

            public Events() {
            }

            public Events(Integer id) {
                        this.id = id;
            }

            public Events(Integer id, String title, String description, Date time) {
                        this.id = id;
                        this.title = title;
                        this.description = description;
                        this.time = time;
            }

            public Integer getId() {
                        return id;
            }

            public void setId(Integer id) {
                        this.id = id;
            }

            public String getTitle() {
                        return title;
            }

            public void setTitle(String title) {
                        this.title = title;
            }

            public String getDescription() {
                        return description;
            }

            public void setDescription(String description) {
                        this.description = description;
            }

            public Date getTime() {
                        return time;
            }

            public void setTime(Date time) {
                        this.time = time;
            }

            @Override
            public int hashCode() {
                        int hash = 0;
                        hash += (id != null ? id.hashCode() : 0);
                        return hash;
            }

            @Override
            public boolean equals(Object object) {
                        // TODO: Warning - this method won't work in the case the id fields are not set
                        if (!(object instanceof Events)) {
                                    return false;
                        }
                        Events other = (Events) object;
                        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                                    return false;
                        }
                        return true;
            }

            @Override
            public String toString() {
                        return "edu.kist.bit.foodybag.entity.Events[ id=" + id + " ]";
            }
            
}
