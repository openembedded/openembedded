DESCRIPTION = "NoteCase is a hierarchical note manager (aka. outliner)." "
AUTHOR = "Mioslav Rajcic"
HOMEPAGE = "notecase.sf.net"
SECTION = "x11/utils"
LICENSE = "BSD"

DEPENDS = "zlib gtk+ gnome-vfs"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}_src.tar.gz\
	  file://no-hardcoded-cxx.patch;patch=1"

inherit pkgconfig

do_compile_prepend() {
	cp ${STAGING_LIBDIR}/libz.a ${S}/src/lib/zlib/
}


do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/doc
	install -d ${D}${datadir}/doc/notecase
	install -d ${D}${datadir}/icons
	install -m 644 ${S}/docs/notecase.desktop ${D}${datadir}/applications
        install -m 644 ${S}/docs/help.ncd ${D}${datadir}/doc/notecase/help.ncd
        install -m 644 ${S}/res/notecase.xpm ${D}${datadir}/icons/notecase.xpm
	install -m 755 ${S}/bin/notecase ${D}${bindir}/
}
