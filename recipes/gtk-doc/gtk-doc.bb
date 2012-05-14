SECTION = "x11/base"
SRC_URI = "file://gtk-doc.m4"
LICENSE = "LGPLv2"
PR = "r4"

ALLOW_EMPTY_${PN} = "1"

do_install() {
	install -d ${D}/${datadir}/aclocal
	install -m 0644 ${WORKDIR}/gtk-doc.m4 ${D}/${datadir}/aclocal
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
