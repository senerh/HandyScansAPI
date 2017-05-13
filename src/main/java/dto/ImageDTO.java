package dto;

import java.io.Serializable;

public class ImageDTO implements Serializable {

    private String url;

    public ImageDTO(String url) {
        this.url = url;
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
        if (!(o instanceof ImageDTO)) return false;

        ImageDTO imageDTO = (ImageDTO) o;

        return url.equals(imageDTO.url);

    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "url='" + url + '\'' +
                '}';
    }
}
