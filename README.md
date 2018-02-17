# Shonen Touch API
Restful API based on lirescan.net website which provides scans from several mangas.

## Development environment
* Java 1.8.0_101
* WildFly 10.1.0.Final

## Documentation
### All resources
| Description | Method | Path | Result |
| -- | -- | -- | -- |
| Get all mangas | GET | /mangas | List\<MangaDTO\> |
| Get a manga | GET | /mangas/{manga} | MangaDTO |
| Get all scans from a given manga | GET | /mangas/{manga}/scans | List\<ScanDTO\> |
| Get a scan from a given manga | GET | /mangas/{manga}/scans/{scan} | ScanDTO |
| Get all pages from a given manga and scan | GET | /mangas/{manga}/scans/{scan}/pages | List\<PageDTO\> |
| Get a page from a given manga and scan | GET | /mangas/{manga}/scans/{scan}/pages/{page} | PageDTO |

### All DTO
| MangaDTO | ScanDTO | PageDTO |
| -- | -- | -- |
| ```String slug``` | ```String num``` | ```String num``` |
| ```String name``` |  | ```String url``` |
| ```String url``` |  |  |
| ```String lastScan``` |  |  |

### Examples
| Resource | Result |
| -- | -- |
| /mangas | ```[{"slug":"my-manga","name":"My Manga","lastScan":"3","url":"http://www.foo.bar/my-manga/preview.jpg"},{"slug":"your-manga","name":"Your Manga","lastScan":"17","url":"http://www.foo.bar/your-manga/preview.jpg"}]``` |
| /mangas/my-manga | ```{"slug":"my-manga","name":"My Manga","lastScan":"3","url":"http://www.foo.bar/my-manga/preview.jpg"}``` |
| /mangas/my-manga/scans | ```[{"num":"1"},{"num":"2"},{"num":"3"}]``` |
| /mangas/my-manga/scans/1 | ```{"num":"1"}``` |
| /mangas/my-manga/scans/1/pages | ```[{"num":"1","url":"http://www.foo.bar/my-manga/first-page.jpg"},{"num":"2","url":"http://www.foo.bar/my-manga/second-page.jpg"},{"num":"3","url":"http://www.foo.bar/my-manga/third-page.jpg"},{"num":"4","url":"http://www.foo.bar/my-manga/fourth-page.jpg"}]``` |
| /mangas/my-manga/scans/1/pages/1 | ```{"num":"1","url":"http://www.foo.bar/my-manga/first-page.jpg"}``` |

## Author
* [Hakan SENER](https://senerh.github.io/)
