DESCRIPTION = "The Gallery v1 web image gallery"
SECTION = "apps"
LICENSE = "GPL"
RDEPENDS = "apache2 modphp imagemagick jhead"
PR = "r2"

SRC_URI = "http://{SOURCEFORGE_MIRROR}/sourceforge/gallery/gallery-${PV}-pl1.tar.gz"

S = "${WORKDIR}/gallery"

inherit autotools

HTTPCONF = "${sysconfdir}/apache2/httpd.conf"
DEST_DIR = "${datadir}/apache2/htdocs/"

#
# don't list the albums as a file - it might get auto-deleted
#
FILES_${PN} = "${DEST_DIR}/gallery ${sysconfdir}/apache2/modules.d"


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
	mkdir -p ${D}/${DEST_DIR} ${D}${sysconfdir}/apache2/modules.d
	cp -pPR ${S} ${D}/${DEST_DIR}
	cp ${FILESDIR}/gallery.conf  ${D}${sysconfdir}/apache2/modules.d/95_gallery.conf
}

# remove the gallery code, but not the albums!
pkg_postrm_${PN}() {
	rm -rf ${DEST_DIR}/gallery /${sysconfdir}/apache2/modules.d/95_gallery.conf
}

SRC_URI[md5sum] = "d2f52d92776f47bf353787237607f23c"
SRC_URI[sha256sum] = "9f17181cd8bf46203a288e3fc1d9bd82d5dc011fe419d33bee2f62bace081f08"
