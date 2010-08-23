DESCRIPTION = "Free GPS navigation for car and outdoor with OpenStreetMap maps"
HOMEPAGE = "http://www.gps-routes.info/index.php?name=Content&pa=showpage&pid=1"
LICENSE = "GPL"
DEPENDS = "ecore evas imlib2 gpsd edje-native"

SRC_URI = "http://www.gps-routes.info/debian/pool/main/m/mcnavi/mcnavi_${PV}.tar.gz;name=archive"
PR = "r1"

SRC_URI[archive.md5sum] = "627d36d735b866ecb0dc3ad350fe815d"
SRC_URI[archive.sha256sum] = "70abe699d93adfa544fb1243356b71ccc0178e23af743726ac5e707825b11e06"

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
  # replace link to (sometimes) non-existent file with empty file
  rm -f ${S}/INSTALL; touch ${S}/INSTALL
}

inherit autotools
