require navit.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz"

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"
