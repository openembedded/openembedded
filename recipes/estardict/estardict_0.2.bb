DESCRIPTION = "EstarDict is a offline dictionary reader"
HOMEPAGE = "http://www.vaudano.eu/wiki/en/estardict"
AUTHOR = "Luca Vaudano"
LICENSE = "GPLv3"
SECTION = "e/apps"
DEPENDS = "elementary"

SRC_URI = "http://www.vaudano.eu/projects/${PN}/${PN}-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "2aaad7efc6658539f68f8cf093dd4361"
SRC_URI[archive.sha256sum] = "70bb4ac9c06eb9e7cd5aacc6abaf265ebc62330cf9d874d17886a7fcbbe3fad9"

inherit autotools
