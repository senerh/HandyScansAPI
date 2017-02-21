package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MangaLastScanDTO {

    private MangaDTO mangaDTO;

    private ScanDTO scanDTO;


    public MangaLastScanDTO() {

    }

    public MangaLastScanDTO(MangaDTO mangaDTO, ScanDTO scanDTO) {
        this.mangaDTO = mangaDTO;
        this.scanDTO = scanDTO;
    }

    public MangaDTO getMangaDTO() {
        return mangaDTO;
    }

    public void setMangaDTO(MangaDTO mangaDTO) {
        this.mangaDTO = mangaDTO;
    }

    public ScanDTO getScanDTO() {
        return scanDTO;
    }

    public void setScanDTO(ScanDTO scanDTO) {
        this.scanDTO = scanDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MangaLastScanDTO)) return false;

        MangaLastScanDTO that = (MangaLastScanDTO) o;

        if (mangaDTO != null ? !mangaDTO.equals(that.mangaDTO) : that.mangaDTO != null) return false;
        return scanDTO != null ? scanDTO.equals(that.scanDTO) : that.scanDTO == null;

    }

    @Override
    public int hashCode() {
        int result = mangaDTO != null ? mangaDTO.hashCode() : 0;
        result = 31 * result + (scanDTO != null ? scanDTO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MangaLastScanDTO{" +
                "mangaDTO=" + mangaDTO +
                ", scanDTO=" + scanDTO +
                '}';
    }
}
