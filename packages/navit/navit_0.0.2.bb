DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+"
PR = "r1"

inherit autotools 

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz" 

EXTRA_OECONF = "--disable-gui-sdl --disable-binding-python --disable-samplemap --enable-avoid-unaligned --enable-avoid-float"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"
FILES_${PN}-dev += "${libdir}/${PN}/*/*.so"
