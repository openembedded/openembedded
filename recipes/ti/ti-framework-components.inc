DESCRIPTION = "TI Framework Components"
HOMEPAGE = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/fc"
SECTION = "devel"
LICENSE = "BSD"

require ti-paths.inc
require ti-staging.inc

PR = "r1"

S = "${WORKDIR}/framework_components_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/fc/${PV}/exports/framework_components_${PV},lite.tar.gz;name=fctarball"

do_install() {
    install -d ${D}${FC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${FC_INSTALL_DIR_RECIPE}
}

