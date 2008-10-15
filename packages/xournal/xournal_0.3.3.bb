HOMEPAGE = "http://xournal.sf.net/"
DESCRIPTION = "Xournal is an application for notetaking, sketching, keeping a journal using a stylus."
DEPENDS = "gtk+ libgnomecanvas libgnomeprintui"
SECTION = "x11"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://xournal.sourceforge.net/xournal-${PV}.tar.gz \
           file://xournal.desktop"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${WORKDIR}/xournal.desktop ${D}${datadir}/applications/
}

