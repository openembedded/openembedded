DESCRIPTION = "A full fledged WikiWiki system written in Python"
LICENSE = "GPL"
SECTION = "network"
HOMEPAGE = "http://moinmoin.wikiwikiweb.de/"
PRIORITY = "optional"
PR = "ml0"

SRC_URI = "http://static.moinmo.in/files/moin-${PV}.tar.gz"

inherit distutils

do_install_append() {
	mv -f ${D}${datadir}/share/* ${D}${datadir}/
}

