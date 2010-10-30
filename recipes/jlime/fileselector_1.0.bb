DESCRIPTION = "Fileselector is an SDL-based file chooser dialog"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-ttf"
RDEPENDS = "ttf-dejavu-sans-condensed"

SRC_URI = "http://jlime.com/downloads/development/software/fileselector-1.0.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "7dc2f18a52778c3277cafc23ffdd4022"
SRC_URI[sha256sum] = "d9be5ad183b55aa9af50e89b04de591a488dfc8d1d756e01e13fe183e0a168e7"
