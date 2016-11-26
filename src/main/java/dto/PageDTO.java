package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PageDTO {

    private String num;

    public PageDTO() {

    }

    public PageDTO(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageDTO)) return false;

        PageDTO pageDTO = (PageDTO) o;

        return num != null ? num.equals(pageDTO.num) : pageDTO.num == null;
    }

    @Override
    public int hashCode() {
        return num != null ? num.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "num='" + num + '\'' +
                '}';
    }
}
