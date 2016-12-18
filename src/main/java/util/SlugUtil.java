package util;

import dto.MangaDTO;
import org.apache.commons.lang3.text.WordUtils;

public class SlugUtil {

    public static String slugToScanSlug(String slug) {
        return slug + "-lecture-en-ligne";
    }

    public static String scanSlugToSlug(String lirescanSlug) {
        return lirescanSlug.replace("-lecture-en-ligne", "");
    }

    public static String slugToName(String slug) {
        return WordUtils.capitalize(slug.replace('-', ' '));
    }

    public static MangaDTO slugToMangaDTO(String slug) {
        return new MangaDTO(slug, slugToName(slug));
    }
}
