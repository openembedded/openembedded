require navit.inc

PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz \
	   file://navit.xml-so.patch;patch=1 \
	   file://navit.desktop"

EXTRA_OECONF = "--disable-binding-python --disable-gui-sdl --disable-samplemap --enable-avoid-float --enable-avoid-unaligned"

do_install_append() {
	install -d ${D}/usr/share/applications/
	
	install -m 0644 ${WORKDIR}/navit.desktop ${D}/usr/share/applications/
}

