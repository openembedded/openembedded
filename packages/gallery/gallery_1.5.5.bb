SECTION = "apps"
DESCRIPTION = "The Gallery v1 web image gallery"
LICENSE = "GPL"
#
RDEPENDS = "apache2 modphp imagemagick jhead"

PR = "r1"
S = "${WORKDIR}/gallery"
HTTPCONF=/etc/apache2/httpd.conf
DEST_DIR=/usr/share/apache2/htdocs/
#
# don't list the albums as a file - it might get auto-deleted
#
FILES_${PN} = "${DEST_DIR}/gallery /etc/apache2/modules.d"

SRC_URI = "http://easynews.dl.sourceforge.net/sourceforge/gallery/gallery-${PV}-pl1.tar.gz"

inherit autotools 

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
	cp -a ${S} ${D}/${DEST_DIR}
	cp ${FILESDIR}/gallery.conf  ${D}/etc/apache2/modules.d/95_gallery.conf
}

# remove the gallery code, but not the albums!
pkg_postrm_${PN}() {
	rm -rf ${DEST_DIR}/gallery /etc/apache2/modules.d/95_gallery.conf
}
