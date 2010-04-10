PR         = "r0"
LICENSE    = "GPL"

DEPENDS = ""

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz"

S = "${WORKDIR}/${PN}"

FILES_${PN} = "${datadir}"


do_install() {

  install -d ${D}/${datadir}
  cp -pPR ${S}/icons/  ${D}/${datadir}/

}


SRC_URI[md5sum] = "85ccc685b72f6f77da8a4b0ef7c5281b"
SRC_URI[sha256sum] = "8dcd3aac06f24111461433353015cd36bfaaf45b74ff9aa336713759b6759b0c"
