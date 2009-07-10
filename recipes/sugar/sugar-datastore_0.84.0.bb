DESCRIPTION = "Sugar datastore"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "sugar-toolkit python-xappy "
RDEPENDS = "sugar-toolkit sugar-base python-xappy python-cjson"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-datastore/${PN}-${PV}.tar.bz2"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


FILES_${PN} += "${datadir}/dbus-1"

