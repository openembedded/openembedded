DESCRIPTION = "Framework Components for TI ARM/DSP processors"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/fc/${PV}/exports/framework_components_${PV}.tar.gz"

require ti-paths.inc

S = "${WORKDIR}/framework_components_${PV}"

# compile time dependencies
DEPENDS += "ti-xdctools-native ti-xdais-native ti-linuxutils"

do_compile () {
        echo "! Do not rebuild for now !"
}

# stage tree - other packages may need this
do_stage() {
    install -d ${FC_INSTALL_DIR}
    cp -pPrf ${S}/* ${FC_INSTALL_DIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
INHIBIT_PACKAGE_STRIP = "1"
