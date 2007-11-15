DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+"
PV = "0.0.2+cvs${SRCDATE}"
PR = "r0"

inherit autotools
S = "${WORKDIR}/navit"

SRC_URI = "cvs://anonymous@navit.cvs.sourceforge.net/cvsroot/navit;module=navit \
#          file://compile-fix.patch;patch=1"
          "

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"
#--enable-shared

EXTRA_AUTORECONF = " -I m4"

FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"

