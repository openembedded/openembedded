DESCRIPTION = "TI eXpress DSP Algorithm Interface Standard (XDAIS) specification"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/xdais"
LICENSE = "GPLv2"
SECTION = "devel"

require ti-paths.inc
require ti-staging.inc

PR = "r1"

S = "${WORKDIR}/xdais_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/xdais/${PV}/exports/xdais_${PV}.tar.gz;name=xdaistarball"

do_install() {
    install -d ${D}${XDAIS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${XDAIS_INSTALL_DIR_RECIPE}
} 

