DESCRIPTION = "Codec combos for omap3530"
DEPENDS = "codec-engine"
LICENCE = "unknown"

require ti-paths.inc

# TODO update this...
# https://www-a.ti.com/downloads/sds_support/applications_packages/dmai/dmai_1_20_00_06/dmai_setuplinux_1_20_00_06.bin
# Install the above link and put the omap3530_dvsdk_combos_3_16.tar.gz file in the same directory as this recipe
SRC_URI = "file://omap3530_dvsdk_combos_3_16.tar.gz \
   "

S = "${WORKDIR}/omap3530_dvsdk_combos_3_16"
# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "316"

PACKAGE_ARCH = "${MACHINE_ARCH}"

TARGET = "all"

export CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/cetools"

do_compile() {
	sed -i -e s:/db/toolsrc/library/vendors2005/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
	-e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
	-e s:/home/dvsdkval/workdir/OMAP3530/nfs/workdir/opt/toolchain/arm-2007q3:${CROSS_DIR}:g \
	${S}/config.bld

	oe_runmake clean
	oe_runmake
}

do_install () {
	echo oe_runmake install
}

do_stage () {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecs
	cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecs
}
