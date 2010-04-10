HOMEPAGE = "http://xournal.sf.net/"
DESCRIPTION = "Xournal is an application for notetaking, sketching, keeping a journal using a stylus."
DEPENDS = "gtk+ libgnomecanvas libgnomeprintui"
# For pdftopnm:
RDEPENDS = "poppler"
SECTION = "x11"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://xournal.sourceforge.net/xournal-${PV}.tar.gz \
           file://xournal.desktop"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/xournal.desktop ${D}${datadir}/applications/
}


SRC_URI[md5sum] = "e0f356e0a7b310b0d4b2976e6b7b74fd"
SRC_URI[sha256sum] = "bb797a384b9acb8209fea572934d1b1484c5de41f062fe152ae99962f52f98ea"
