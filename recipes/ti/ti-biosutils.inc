DESCRIPTION = "TI DSP/BIOS Utilities"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/Bios_Utils"

require ti-paths.inc
require ti-staging.inc

S = "${WORKDIR}/biosutils_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/Bios_Utils/${PV}${PVsuffix}/exports/biosutils_${PV}.tar.gz;name=biosutilstarball"

do_install() {
    install -d ${D}${BIOSUTILS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${BIOSUTILS_INSTALL_DIR_RECIPE}
}

