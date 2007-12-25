require navit.inc

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz" 

EXTRA_OECONF = "--disable-gui-sdl --disable-binding-python --disable-samplemap --enable-avoid-unaligned --enable-avoid-float"
