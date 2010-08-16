DESCRIPTION = "EstarDict is a offline dictionary reader"
HOMEPAGE = "http://www.vaudano.eu/wiki/en/estardict"
AUTHOR = "Luca Vaudano"
LICENSE = "GPLv3"
SECTION = "e/apps"
DEPENDS = "elementary"
PR = "r1"

SRC_URI = "http://www.vaudano.eu/projects/${PN}/${PN}-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "817ed4d8a0ef2a8c94ace4ffb7a3d15b"
SRC_URI[archive.sha256sum] = "93e6b40576d2f0facdd2a684d1bb6d5491f147a30aa199ad6d56995792b93e27"

inherit autotools
