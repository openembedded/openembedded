SECTION = "console/utils"
DESCRIPTION = "Utilities for User-Mode-Linux"
LICENSE = "GPL"
DEPENDS = "zlib ncurses readline"

SRC_URI = "http://mirror.usermodelinux.org/uml/uml_utilities_${PV}.tar.bz2 \
           file://fix-ldflags.patch;patch=1"
S = "${WORKDIR}/tools"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake install DESTDIR=${D}
}
