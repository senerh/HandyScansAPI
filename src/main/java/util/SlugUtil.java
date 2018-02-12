package util;

public class SlugUtil {

    public static String slugToScanSlug(String slug) {
        return slug + "-lecture-en-ligne";
    }

    public static String scanSlugToSlug(String lirescanSlug) {
        return lirescanSlug.replace("-lecture-en-ligne", "");
    }
}
