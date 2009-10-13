inherit native
require ti-xdctools.inc

# download xdctools_setuplinux_3_10_03.bin from https://www-a.ti.com/downloads/sds_support/targetcontent/rtsc/xdctools_3_10/xdctools_3_10_03/index_external.html and copy in Arago (or OE) download directory

SRC_URI	= "http://install.source.dir.local/xdctools_setuplinux_3_10_03.bin"
BINFILE="xdctools_setuplinux_3_10_03.bin"

S = "${WORKDIR}/xdctools_3_10_03"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "310"
PR = "r16"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}
}

AUTOTOOLS_NATIVE_STAGE_INSTALL="1"

