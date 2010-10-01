HOMEPAGE = "http://www.matroska.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"

SRC_URI = "http://dl.matroska.org/downloads/${PN}/${P}.tar.bz2"

EXTRA_OEMAKE = "CROSS=${TARGET_PREFIX} prefix=${D}${prefix} -C make/linux"

do_compile() {
        oe_runmake
}

do_install() {
        oe_runmake install
}
