PR         = "r0"
LICENSE    = "GPL"

DEPENDS = "sdk-default-theme"
RDEPENDS = "sdk-default-theme"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-1.0"

FILES_${PN} = "${datadir}"


do_install() {

  install -d ${D}/${datadir}
  cp -pPR ${S}/themes/  ${D}/${datadir}/

}


SRC_URI[md5sum] = "ed7202fcabcce02a41225906deb0c682"
SRC_URI[sha256sum] = "1bc620973aa9448c7374e5c673f21b11f60abbc1d887b9719dd4a90cb99bea64"
