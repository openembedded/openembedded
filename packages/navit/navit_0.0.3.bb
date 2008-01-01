require navit.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz \
	   file://navit.xml-so.patch;patch=1"

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"
