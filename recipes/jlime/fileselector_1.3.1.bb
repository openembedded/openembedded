DESCRIPTION = "Fileselector is an SDL-based file chooser dialog"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-ttf"
RDEPENDS_${PN} = "ttf-dejavu-sans-condensed"

SRC_URI = "http://jlime.com/downloads/development/software/fileselector-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "239ec080c7c503e037379ac4d344ab3a"
SRC_URI[sha256sum] = "2e2bc28d80431de504ed039a289181796de40492ed2de31813904a5ff6714518"
