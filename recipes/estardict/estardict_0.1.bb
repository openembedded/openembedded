DESCRIPTION = "EstarDict is a offline dictionary reader"
HOMEPAGE = "http://www.vaudano.eu/wiki/en/estardict"
AUTHOR = "Luca Vaudano"
LICENSE = "GPLv3"
SECTION = "e/apps"
DEPENDS = "elementary"

SRC_URI = "http://www.vaudano.eu/projects/${PN}/${PN}-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "cb66965f3f6725cce8010bd8fd0e4618"
SRC_URI[archive.sha256sum] = "c12fb0608d2de7bdb1b1f1002b691ceea4286e69d8374548c7549e1153c1286e"

inherit autotools
