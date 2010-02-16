DESCRIPTION = "writeprom script for overo"

PR="r0"

SRC_URI = "file://writeprom.sh"

S = "${WORKDIR}"

do_install () {
  install -d ${D}${bindir}/
  install -m 0755 ${WORKDIR}/writeprom.sh ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES_${PN} = "/*"

