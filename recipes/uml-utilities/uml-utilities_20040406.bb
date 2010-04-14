SECTION = "console/utils"
DESCRIPTION = "Utilities for User-Mode-Linux"
LICENSE = "GPL"
DEPENDS = "zlib ncurses readline"

SRC_URI = "http://mirror.usermodelinux.org/uml/uml_utilities_${PV}.tar.bz2 \
           file://fix-ldflags.patch;patch=1"
SRC_URI[md5sum] = "2c1ccd9efacbfb39e42d482b89b2550a"
SRC_URI[sha256sum] = "4f179b1db021ef15ac7e9b2eed57c525db127a754c574f591c367460cded9f41"

S = "${WORKDIR}/tools"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake install DESTDIR=${D}
}
