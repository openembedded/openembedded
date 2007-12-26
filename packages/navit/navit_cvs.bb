require navit.inc

PV = "0.0.3+cvs${SRCDATE}"
PR = "r0"

S = "${WORKDIR}/navit"

SRC_URI = "cvs://anonymous@navit.cvs.sourceforge.net/cvsroot/navit;module=navit"

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"

EXTRA_AUTORECONF = " -I m4"

