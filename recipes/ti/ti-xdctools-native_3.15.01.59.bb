inherit native
require ti-xdctools.inc

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/rtsc/xdctools_3_15//exports/xdctools_setuplinux_3_15_01_59.bin"
BINFILE = "xdctools_setuplinux_3_15_01_59.bin"

S = "${WORKDIR}/xdctools_3_15_01_59"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "315"
PR = "r4"

do_stage() {
    install -d -m 0755 ${STAGING_DIR_NATIVE}/${PN}
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/${PN}
	chmod 755 -R  ${STAGING_DIR_NATIVE}/${PN}
	# rm_work fails if you don't chmod S:
	chmod 755 -R  ${S}
}

AUTOTOOLS_NATIVE_STAGE_INSTALL = "1"

