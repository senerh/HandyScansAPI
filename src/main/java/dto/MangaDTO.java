package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MangaDTO {

    private String slug;
    private String name;

    public MangaDTO() {

    }

    public MangaDTO(String slug, String name) {
        this.slug = slug;
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MangaDTO)) return false;

        MangaDTO mangaDTO = (MangaDTO) o;

        if (slug != null ? !slug.equals(mangaDTO.slug) : mangaDTO.slug != null) return false;
        return name != null ? name.equals(mangaDTO.name) : mangaDTO.name == null;

    }

    @Override
    public int hashCode() {
        int result = slug != null ? slug.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MangaDTO{" +
                "slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
