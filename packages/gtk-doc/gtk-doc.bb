SECTION = "x11/base"
SRC_URI = "file://gtk-doc.m4"
LICENSE = "LGPL"

do_stage() {
	install -m 0644 ${WORKDIR}/gtk-doc.m4 ${STAGING_DATADIR}/aclocal
}
