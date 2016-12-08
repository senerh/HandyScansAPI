package util;

import org.apache.commons.lang3.text.WordUtils;

public class SlugUtil {

    public static String slugToLirescanSlug(String slug) {
        return slug + "-lecture-en-ligne";
    }

    public static String lirescanSlugToSlug(String lirescanSlug) {
        return lirescanSlug.replace("-lecture-en-ligne", "");
    }

    public static String lirescanSlugToName(String lirescanSlug) {
        return WordUtils.capitalize(lirescanSlugToSlug(lirescanSlug).replace('-', ' '));
    }

    public static String slugToName(String slug) {
        return WordUtils.capitalize(slug.replace('-', ' '));
    }
}
