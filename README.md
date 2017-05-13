# Shonen Touch API
Restful API based on lirescan.net website which provides scans from several mangas.

## Development environment
* Java 1.8.0_101
* Tomcat 9.0.0.M10

## Documentation
### All resources
| Description | Method | Path | Result |
| -- | -- | -- | -- |
| Get all mangas | GET | /mangas | List\<MangaDTO\> |
| Get all mangas | GET | /fullmangas | List\<FullMangaDTO\> |
| Get all scans from a given manga | GET | /mangas/{manga}/scans | List\<ScanDTO\> |
| Get all pages from a given manga and scan | GET | /mangas/{manga}/scans/{scan}/pages | List\<PageDTO\> |
| Get an image from a given manga, scan and page | GET | /mangas/{manga}/scans/{scan}/pages/{page}/image | ImageDTO |

### All DTOs
| MangaDTO | FullMangaDTO | ScanDTO | PageDTO | ImageDTO |
| -- | -- | -- | -- | -- |
| ```String slug``` | ```String slug``` | ```String num``` | ```String num``` | ```String url```
| ```String name``` | ```String name``` |  |  |  |
| | ```String url``` |  |  |  |
| | ```String last_scan``` |  |  |  |

### Examples
| Resource | Result |
| -- | -- |
| /mangas | ```[{"slug":"my-manga","name":"My Manga"},{"slug":"your-manga","name":"Your Manga"}]``` |
| /fullmangas | ```[{"slug":"my-manga","name":"My Manga","url":"http://www.foo.bar/my-manga/preview.jpg","last_scan":"3"},{"slug":"your-manga","name":"Your Manga","url":"http://www.foo.bar/your-manga/preview.jpg","last_scan":"17"}``` |
| /mangas/my-manga/scans | ```[{"num":"1"},{"num":"2"},{"num":"3"}]``` |
| /mangas/my-manga/scans/1/pages | ```[{"num":"1"},{"num":"2"},{"num":"3"},{"num":"4"}]``` |
| /mangas/my-manga/scans/1/pages/1/image | ```{"url":"http://www.foo.bar/my-manga/first-page.jpg"}``` |

## Author
* [Hakan SENER](https://senerh.github.io/)
