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
