package util;

public final class SlugUtil {

    private static final String SUFFIX = "-lecture-en-ligne";

    private SlugUtil() {
        //hide public constructor
    }

    public static String slugToScanSlug(String slug) {
        return slug + SUFFIX;
    }

    public static String scanSlugToSlug(String lirescanSlug) {
        return lirescanSlug.replace(SUFFIX, "");
    }
}
