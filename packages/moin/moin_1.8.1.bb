DESCRIPTION = "A full fledged WikiWiki system written in Python"
LICENSE = "GPL"
SECTION = "network"
HOMEPAGE = "http://moinmoin.wikiwikiweb.de"
PRIORITY = "optional"
PR = "ml1"

SRC_URI = "http://static.moinmo.in/files/moin-${PV}.tar.gz"

inherit distutils

FILES_${PN} += "${datadir}"
