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


SRC_URI[md5sum] = "139ef3045c99dc5c07118b47ff9257e1"
SRC_URI[sha256sum] = "4de076c38b4b64188d23821e7d7a0f6a26b1d6707e768dadda14eb69dcc84598"
