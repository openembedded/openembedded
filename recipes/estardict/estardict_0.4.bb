DESCRIPTION = "EstarDict is a offline dictionary reader"
HOMEPAGE = "http://www.vaudano.eu/wiki/en/estardict"
AUTHOR = "Luca Vaudano"
LICENSE = "GPLv3"
SECTION = "e/apps"
DEPENDS = "elementary"
PR = "r1"

SRC_URI = "http://www.vaudano.eu/projects/${PN}/${PN}-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "2424577d489bc50dcdb80e73e22cb19e"
SRC_URI[archive.sha256sum] = "17d957bc103079e99e95bf727dd63e4cc6ccc5bd02e25c50fc14d1dec682edcd"

inherit autotools
