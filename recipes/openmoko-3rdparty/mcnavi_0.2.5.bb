DESCRIPTION = "Free GPS navigation for car and outdoor with OpenStreetMap maps"
HOMEPAGE = "http://www.gps-routes.info/index.php?name=Content&pa=showpage&pid=1"
LICENSE = "GPL"
DEPENDS = "ecore evas imlib2 gpsd edje-native"
PR = "r2"

SRC_URI = "http://www.gps-routes.info/debian/pool/main/m/mcnavi/mcnavi_${PV}.tar.gz;name=archive \
           file://gpsd-2.90.patch;patch=1"

SRC_URI[archive.md5sum] = "b572c3691f05e22b37efd6cd53da203e"
SRC_URI[archive.sha256sum] = "ee6792bef93070319141ee2020b7ae376527e3b8043f0f540bcd58d418576d44"

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
  # replace link to (sometimes) non-existent file with empty file
  rm -f ${S}/INSTALL; touch ${S}/INSTALL
}

inherit autotools
