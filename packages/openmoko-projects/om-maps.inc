DESCRIPTION = "Map of ${MAP_NAME}, for use with Locations application. \
               Data from OpenStreetMap.org, licenced CC-by-SA."
HOMEPAGE = "http://wiki.openmoko.org/wiki/Om_2008.8_Locations"
SECTION = "network/misc"
LICENSE = "Creative Commons Attribution-ShareAlike 2.0"

SRC_URI = "http://people.openmoko.org/olv/om-maps/${MAP_VER}/${MAP_FN}"

MAP_DIR = "${datadir}/om-maps"
FILES_${PN} = "${MAP_DIR}/${MAP_FN}"

PACKAGES = "${PN}"
PACKAGE_ARCH = "all"
ALIAS_NAME_${PN}= "${@bb.data.getVar('MAP_NAME', d, 1).replace(' ','_')}"
PKG_TAGS_${PN} = "group::maps alias::${ALIAS_NAME_${PN}}"

do_install() {
        install -d ${D}${MAP_DIR}
        cp -f ${WORKDIR}/${MAP_FN} ${D}${MAP_DIR}
}
