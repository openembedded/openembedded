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


SRC_URI[md5sum] = "c617d08d2c565eef0d8defb304925ade"
SRC_URI[sha256sum] = "77f3bf12ce006eb06fc79d9c60a13ff69403ca6c28cc2babafb0ae35a2240ead"
