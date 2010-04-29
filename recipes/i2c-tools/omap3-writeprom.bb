DESCRIPTION = "Writeprom script for omap3 boards with EEPROM on there expansionboard - see http://www.elinux.org/BeagleBoardPinMux#Vendor_and_Device_IDs"


SRC_URI = "file://writeprom.sh"

S = "${WORKDIR}"

do_install () {
  install -d ${D}${bindir}/
  install -m 0755 ${WORKDIR}/writeprom.sh ${D}${bindir}/
}

PACKAGE_ARCH = "all"
RDEPENDS_${PN} = "i2c-tools"
FILES_${PN} = "${bindir}"

