package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MangaLastScanDTO {

    private String slug;
    private String name;
    @XmlElement(name = "last_scan")
    private String lastScan;

    public MangaLastScanDTO() {

    }

    public MangaLastScanDTO(String slug, String name, String lastScan) {
        this.slug = slug;
        this.name = name;
        this.lastScan = lastScan;
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

    public String getLastScan() {
        return lastScan;
    }

    public void setLastScan(String lastScan) {
        this.lastScan = lastScan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MangaLastScanDTO)) return false;

        MangaLastScanDTO that = (MangaLastScanDTO) o;

        if (slug != null ? !slug.equals(that.slug) : that.slug != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return lastScan != null ? lastScan.equals(that.lastScan) : that.lastScan == null;

    }

    @Override
    public int hashCode() {
        int result = slug != null ? slug.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastScan != null ? lastScan.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MangaLastScanDTO{" +
                "slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", lastScan='" + lastScan + '\'' +
                '}';
    }
}
