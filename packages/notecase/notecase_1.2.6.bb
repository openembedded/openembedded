DESCRIPTION = "NoteCase is a hierarchical note manager (aka. outliner)." "
LICENSE = "BSD"

DEPENDS = "zlib gtk+ gnome-vfs"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}_src.tar.gz \
	   file://no-hardcoded-cxx.patch;patch=1"

inherit pkgconfig

do_compile_prepend() {
	cp ${STAGING_LIBDIR}/libz.a ${S}/src/lib/zlib/
}


do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -m 644 ${S}/docs/notecase.desktop ${D}${datadir}/applications
	install -m 755 ${S}/bin/notecase ${D}${bindir}/
}
