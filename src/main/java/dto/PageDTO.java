package dto;

import java.io.Serializable;

public class PageDTO implements Serializable {

    private String num;

    private String url;

    public PageDTO(String num, String url) {
        this.num = num;
        this.url = url;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageDTO)) return false;

        PageDTO pageDTO = (PageDTO) o;

        if (num != null ? !num.equals(pageDTO.num) : pageDTO.num != null) return false;
        return url != null ? url.equals(pageDTO.url) : pageDTO.url == null;

    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "num='" + num + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
