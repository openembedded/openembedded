DESCRIPTION = "Diversity Maps - ${MAP_NAME}"
HOMEPAGE = "http://diversity.projects.openmoko.org/"
SECTION = "network/misc"
LICENSE = "Creative Commons Attribution-ShareAlike 2.0"

SRC_URI = "http://people.openmoko.org/olv/diversity/${MAP_VER}/${MAP_FN}"

MAP_DIR = "${datadir}/diversity-nav/maps"
FILES_${PN} = "${MAP_DIR}/${MAP_FN}"

PACKAGES = "${PN}"
PACKAGE_ARCH = "all"
PKG_TAGS_${PN} = "group::maps"

do_install() {
        install -d ${D}${MAP_DIR}
        cp -f ${WORKDIR}/${MAP_FN} ${D}${MAP_DIR}
}
