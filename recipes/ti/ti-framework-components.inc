DESCRIPTION = "Framework Components for TI ARM/DSP processors"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/fc/${PV}/exports/framework_components_${PV},lite.tar.gz;name=fctarball"

require ti-paths.inc
require ti-staging.inc

S = "${WORKDIR}/framework_components_${PV}"

# compile time dependencies
DEPENDS += "ti-xdctools ti-xdais ti-linuxutils"

do_compile () {
        echo "! Do not rebuild for now !"
}

# stage tree - other packages may need this
do_install() {
    install -d ${D}${FC_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${FC_INSTALL_DIR_RECIPE}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
