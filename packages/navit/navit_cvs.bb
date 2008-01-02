require navit.inc

PV = "0.0.3+cvs${SRCDATE}"
PR = "r2"

S = "${WORKDIR}/navit"

SRC_URI = "cvs://anonymous@navit.cvs.sourceforge.net/cvsroot/navit;module=navit \
           file://navit.xml-so.patch;patch=1 \
	   file://navit.desktop"

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"

EXTRA_AUTORECONF = " -I m4"

do_install_append() {
	install -d ${D}/usr/share/applications/
	
	install -m 0644 ${WORKDIR}/navit.desktop ${D}/usr/share/applications/
}
