package JAXB;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObject")
public class DataObject {

    @JsonProperty
    @XmlAttribute(required = true)
    private int id;

    @JsonProperty
    @XmlElement(required = true)
    private String name;

    @JsonProperty
    @JsonDeserialize(as = ArrayList.class, contentAs = IndexObj.class)
    @XmlElement(required = true)
    @XmlElementWrapper(name = "indexList")
    private List<IndexObj> indexes;

    public DataObject(int id, String name, List<IndexObj> indexes) {
        this.id = id;
        this.name = name;
        this.indexes = indexes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IndexObj> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<IndexObj> indexes) {
        this.indexes = indexes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataObject that = (DataObject) o;
        return id == that.id && name.equals(that.name) && indexes.equals(that.indexes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, indexes);
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", indexes=" + indexes +
                '}';
    }

    public DataObject() {
    }
}
