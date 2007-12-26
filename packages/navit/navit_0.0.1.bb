require navit.inc

PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz \
           file://compile-fix.patch;patch=1"

EXTRA_OECONF = "--disable-gui-sdl --disable-binding-python --enable-avoid-unaligned --enable-avoid-float"
