DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+"
PV = "0.0.1"
PR = "r2"

inherit autotools 

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz \
	file://compile-fix.patch;patch=1"

EXTRA_OECONF = "--disable-gui-sdl --disable-binding-python --enable-avoid-unaligned --enable-avoid-float"

FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"
