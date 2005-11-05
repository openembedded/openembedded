PR         = "r0"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = ""

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}"

FILES_${PN} = "${datadir}"


do_install() {

  install -d ${D}/${datadir}
  cp -pPR ${S}/icons/  ${D}/${datadir}/

}

