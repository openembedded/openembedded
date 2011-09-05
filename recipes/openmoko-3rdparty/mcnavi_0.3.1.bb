DESCRIPTION = "Free GPS navigation for car and outdoor with OpenStreetMap maps"
HOMEPAGE = "http://www.gps-routes.info/index.php?name=Content&pa=showpage&pid=1"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"
DEPENDS = "ecore evas imlib2 gpsd edje-native mysql5"

SRC_URI = "http://www.gps-routes.info/debian/pool/main/m/mcnavi/mcnavi_${PV}.tar.gz"
SRC_URI[md5sum] = "49e1c513854188521c1d8150446bb4df"
SRC_URI[sha256sum] = "8da57c8fbe8d0dc55ee20d7c9e4f51633fe19ee085887011444a2f2d89b85a42"

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
  sed -i "s#-I/usr/include/mysql#-I${STAGING_INCDIR}/mysql#g" ${S}/src/osm2mcm/Makefile.am
  sed -i "s#-L/usr/lib/mysql#-L${STAGING_LIBDIR}/mysql#g" ${S}/src/osm2mcm/Makefile.am
}

inherit autotools
