DESCRIPTION = "Sugar datastore"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "sugar-toolkit python-xappy "
RDEPENDS = "sugar-toolkit sugar-base python-xappy"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar-datastore/${PN}-${PV}.tar.bz2"

inherit autotools distutils-base

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


FILES_${PN} += "${datadir}/dbus-1"

SRC_URI[md5sum] = "7a6bbb387c1f7cd3ddd6663869df3b88"
SRC_URI[sha256sum] = "3fc7ed937865773089d146f0fce72ee556f0655c612ae840a08dbd1a13d92d39"
