PR         = "r0"
LICENSE    = "GPL"

DEPENDS = ""

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}-0.1"

FILES_${PN} = "${datadir}"


do_install() {

  install -d ${D}/${datadir}
  cp -pPR ${S}/themes/  ${D}/${datadir}/

}


SRC_URI[md5sum] = "39df0bf8ad0a7370a63c283bdcf67219"
SRC_URI[sha256sum] = "114f8be9b73d75811cac866650a64cdbc88348353d281dda3b6aff4c1e109337"
