DESCRIPTION = "Fileselector is an SDL-based file chooser dialog"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-ttf"
RDEPENDS_${PN} = "ttf-dejavu-sans-condensed"

SRC_URI = "http://jlime.com/downloads/development/software/fileselector-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "44e55fd028cf7d3d5e3e5470c85c09e6"
SRC_URI[sha256sum] = "78ba61f19561dde8694c08ca93d04dbf848bb344fbee32d833e26a556ca778ec"
