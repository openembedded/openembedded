DESCRIPTION = "TI DSP Algorithm Interface Standard specification"

# Have a look at http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/xdais/index.html

PVEXTENSION  ?= ""
BASE_SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/xdais/${PV}/exports"

SRC_URI	= "${BASE_SRC_URI}/xdais_${PV}${PVEXTENSION}.tar.gz;name=xdaisgz"

S = "${WORKDIR}/xdais_${PV}${PVEXTENSION}"

require ti-paths.inc
require ti-staging.inc

do_install() {
    install -d ${D}${XDAIS_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${XDAIS_INSTALL_DIR_RECIPE}
} 

