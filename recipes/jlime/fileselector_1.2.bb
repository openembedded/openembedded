DESCRIPTION = "Fileselector is an SDL-based file chooser dialog"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-ttf"
RDEPENDS_${PN} = "ttf-dejavu-sans-condensed"

SRC_URI = "http://jlime.com/downloads/development/software/fileselector-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "650d64020a8eeec33716c60affa2a7d7"
SRC_URI[sha256sum] = "844511ca2c096aad407d53421d5a225a3238130d21f1e31ec3d2449ebefa4300"
