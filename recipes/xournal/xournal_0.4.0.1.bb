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

