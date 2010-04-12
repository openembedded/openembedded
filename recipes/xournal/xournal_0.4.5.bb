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

SRC_URI[md5sum] = "795e4396ded2b67766eb2926be1fb4a9"
SRC_URI[sha256sum] = "a7d7c2cb544451939779276e6e5ee5acc756bd0efb5253de15dc00bfe07755d1"
