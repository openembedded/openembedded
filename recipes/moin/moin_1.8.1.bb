DESCRIPTION = "A full fledged WikiWiki system written in Python"
LICENSE = "GPL"
SECTION = "network"
HOMEPAGE = "http://moinmoin.wikiwikiweb.de"
PRIORITY = "optional"
PR = "ml1"

SRC_URI = "http://static.moinmo.in/files/moin-${PV}.tar.gz"

inherit distutils

FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "4a0dbe4e0cfdc15d30958bdc571bbfd7"
SRC_URI[sha256sum] = "2492f6bd7e2140e62436f11e14b21ec36d17d784fa8271e61f8f06012c83a1d2"
