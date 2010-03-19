DESCRIPTION = "Assassin Packages Thumbnails"
HOMEPAGE = "http://assassin.projects.openmoko.org/"
LICENSE = "GPL"
RDEPENDS = "assassin"
SRCREV = "4690"
PV = "0.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target/thumbnails/;module=result;proto=https"

do_install() {
        install -d ${D}${THUMBNAIL_DIR}
        cp -f ${WORKDIR}/result/${THUMBNAIL_FN} ${D}${THUMBNAIL_DIR}
}

FILES_${PN} = "${THUMBNAIL_DIR}/${THUMBNAIL_FN}"

THUMBNAIL_DIR = "${datadir}/assassin/"
THUMBNAIL_FN = "thumbnail.eet"
