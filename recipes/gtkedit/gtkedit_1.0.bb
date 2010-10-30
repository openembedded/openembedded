DESCRIPTION = "Gtkedit is a simple editor, written using the GTK+ 1.2 toolkit."
HOMEPAGE = "http://gtkedit1.sourceforge.net/"
SECTION = "x11/applications"
LICENSE = "MIT"

DEPENDS = "gtk+-1.2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gtkedit1/gtkedit-${PV}-src.tar.gz \
	   file://gtkedit.desktop"

S = "${WORKDIR}/gtkedit-${PV}-src"

do_compile() {
	${CC} -o gtkedit gtkedit.c -I${STAGING_INCDIR} `gtk-config --cflags` -L${STAGING_LIBDIR} `gtk-config --libs` 
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -m 0755 gtkedit ${D}${bindir}
	install -m 0644 ${WORKDIR}/gtkedit.desktop ${D}${datadir}/applications
}

SRC_URI[md5sum] = "4fc391c80eb79d759d782495d3bf9a4c"
SRC_URI[sha256sum] = "4adc87b592e86af3870de1d6969239d8aab95fa6508ddf32195835a05651763b"
