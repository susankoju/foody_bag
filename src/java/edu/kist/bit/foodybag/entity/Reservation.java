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
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
            @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
            , @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id")
            , @NamedQuery(name = "Reservation.findByUserId", query = "SELECT r FROM Reservation r WHERE r.userId = :userId")
            , @NamedQuery(name = "Reservation.findByOcation", query = "SELECT r FROM Reservation r WHERE r.ocation = :ocation")
            , @NamedQuery(name = "Reservation.findByTime", query = "SELECT r FROM Reservation r WHERE r.time = :time")})
public class Reservation implements Serializable {

            private static final long serialVersionUID = 1L;
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Basic(optional = false)
            @Column(name = "id")
            private Integer id;
            @Basic(optional = false)
            @Column(name = "user_id")
            private int userId;
            @Basic(optional = false)
            @Column(name = "ocation")
            private String ocation;
            @Basic(optional = false)
            @Column(name = "time")
            @Temporal(TemporalType.TIMESTAMP)
            private Date time;
            @Basic(optional = false)
            @Lob
            @Column(name = "message")
            private String message;

            public Reservation() {
            }

            public Reservation(Integer id) {
                        this.id = id;
            }

            public Reservation(Integer id, int userId, String ocation, Date time, String message) {
                        this.id = id;
                        this.userId = userId;
                        this.ocation = ocation;
                        this.time = time;
                        this.message = message;
            }

            public Integer getId() {
                        return id;
            }

            public void setId(Integer id) {
                        this.id = id;
            }

            public int getUserId() {
                        return userId;
            }

            public void setUserId(int userId) {
                        this.userId = userId;
            }

            public String getOcation() {
                        return ocation;
            }

            public void setOcation(String ocation) {
                        this.ocation = ocation;
            }

            public Date getTime() {
                        return time;
            }

            public void setTime(Date time) {
                        this.time = time;
            }

            public String getMessage() {
                        return message;
            }

            public void setMessage(String message) {
                        this.message = message;
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
                        if (!(object instanceof Reservation)) {
                                    return false;
                        }
                        Reservation other = (Reservation) object;
                        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                                    return false;
                        }
                        return true;
            }

            @Override
            public String toString() {
                        return "edu.kist.bit.foodybag.entity.Reservation[ id=" + id + " ]";
            }
            
}
