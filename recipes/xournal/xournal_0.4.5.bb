HOMEPAGE = "http://xournal.sf.net/"
DESCRIPTION = "Xournal is an application for notetaking, sketching, keeping a journal using a stylus."
DEPENDS = "gtk+ libgnomecanvas libgnomeprintui"
# For pdftopnm:
RDEPENDS = "poppler"
SECTION = "x11"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://xournal.sourceforge.net/xournal-${PV}.tar.gz \
           "

inherit autotools pkgconfig

# make desktop-install in Makefile is not useable for us, so just copy the .desktop file from source
do_install_append () {
	install -d ${D}${datadir}/applications/
	install -m 0644 ${S}/xournal.desktop ${D}${datadir}/applications/
}
