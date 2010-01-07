DESCRIPTION = "Code Generation Tools for TI DaVinci and OMAP"

# This file defines function used for extracting .bin file

TI_BIN_UNPK_CMDS="Y:qY:workdir: : "
TI_BIN_UNPK_WDEXT="/cgt"

require ti-eula-unpack.inc
require ti-paths.inc
require ti-staging.inc


do_install() {
    install -d ${D}${CODEGEN_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${CODEGEN_INSTALL_DIR_RECIPE}
}
