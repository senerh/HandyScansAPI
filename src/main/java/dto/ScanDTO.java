package dto;

import java.io.Serializable;

public class ScanDTO implements Serializable, Comparable<ScanDTO> {

    private String num;

    public ScanDTO(String num) {
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
        if (!(o instanceof ScanDTO)) return false;

        ScanDTO scanDTO = (ScanDTO) o;

        return num.equals(scanDTO.num);

    }

    @Override
    public int hashCode() {
        return num.hashCode();
    }

    @Override
    public String toString() {
        return "ScanDTO{" +
                "num='" + num + '\'' +
                '}';
    }

    public int compareTo(ScanDTO o) {
        return Float.compare(Float.parseFloat(num), Float.parseFloat(o.num));
    }
}
