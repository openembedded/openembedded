DESCRIPTION = "TI DSP Code Generation Tools"
HOMEPAGE = "https://www-a.ti.com/downloads/sds_support/TICodegenerationTools/download.htm"
SECTION = "devel"
LICENSE = "TI"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PR = "r4"

S = "${WORKDIR}/cgt6x_${PV}"

SRC_URI = "http://install.source.dir.local/ti_cgt_c6000_${PVwithdots}_setup_linux_x86.bin;name=cgt6xbin"

BINFILE="ti_cgt_c6000_${PVwithdots}_setup_linux_x86.bin"
TI_BIN_UNPK_CMDS="Y:qY:workdir: : "
TI_BIN_UNPK_WDEXT="/cgt6x_${PV}"

do_install() {
    install -d ${D}${CODEGEN_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${CODEGEN_INSTALL_DIR_RECIPE}
}

