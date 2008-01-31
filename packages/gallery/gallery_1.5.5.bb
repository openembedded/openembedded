DESCRIPTION = "The Gallery v1 web image gallery"
SECTION = "apps"
LICENSE = "GPL"
RDEPENDS = "apache2 modphp imagemagick jhead"
PR = "r1"

SRC_URI = "http://easynews.dl.sourceforge.net/sourceforge/gallery/gallery-${PV}-pl1.tar.gz"

S = "${WORKDIR}/gallery"

inherit autotools

HTTPCONF = "/etc/apache2/httpd.conf"
DEST_DIR = "/usr/share/apache2/htdocs/"

#
# don't list the albums as a file - it might get auto-deleted
#
FILES_${PN} = "${DEST_DIR}/gallery /etc/apache2/modules.d"


# No configure step for gallery
do_configure() {
	:
}

# No compile step either
do_compile() {
	:
}

#
do_install() {
	mkdir -p ${D}/${DEST_DIR} ${D}/etc/apache2/modules.d
	cp -pPR ${S} ${D}/${DEST_DIR}
	cp ${FILESDIR}/gallery.conf  ${D}/etc/apache2/modules.d/95_gallery.conf
}

# remove the gallery code, but not the albums!
pkg_postrm_${PN}() {
	rm -rf ${DEST_DIR}/gallery /etc/apache2/modules.d/95_gallery.conf
}
