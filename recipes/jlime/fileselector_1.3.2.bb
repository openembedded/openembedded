DESCRIPTION = "Fileselector is an SDL-based file chooser dialog"
LICENSE = "GPLv2"
PR = "r0"

DEPENDS = "virtual/libsdl libsdl-ttf"
RDEPENDS_${PN} = "ttf-dejavu-sans-condensed"

SRC_URI = "http://jlime.com/downloads/development/software/fileselector-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "25953dacbcf5557c06c53162c921a905"
SRC_URI[sha256sum] = "1fe186506b89c59c642ffd7aa441941d40ed46b6b1d5061d593be156a3bcfcb5"
