DESCRIPTION = "Free GPS navigation for car and outdoor with OpenStreetMap maps"
HOMEPAGE = "http://www.gps-routes.info/index.php?name=Content&pa=showpage&pid=1"
LICENSE = "GPL"
DEPENDS = "ecore evas imlib2 gpsd edje-native"

SRC_URI = "http://www.gps-routes.info/debian/pool/main/m/mcnavi/mcnavi_${PV}.tar.gz"
SRC_URI[md5sum] = "d222351cdb3db9cd040b4666fa1b5f2a"
SRC_URI[sha256sum] = "1ebe5e5be5ccc0ce2dde9adbcc7ec733efa91310da51a8f65b65ccca87692b16"

PR = "r2"

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
  # replace link to (sometimes) non-existent file with empty file
  rm -f ${S}/INSTALL; touch ${S}/INSTALL
}

inherit autotools
