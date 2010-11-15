DESCRIPTION = "Fileselector is an SDL-based file chooser dialog"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-ttf"
RDEPENDS = "ttf-dejavu-sans-condensed"

SRC_URI = "http://jlime.com/downloads/development/software/fileselector-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "fb0e57e86605a8650c90349b6e17c5a6"
SRC_URI[sha256sum] = "8dd35fcb6fcf3af285e2a74420ae2027626f7a1cc64f66da36568884f9a3e30c"
