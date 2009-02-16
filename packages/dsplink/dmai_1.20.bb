DESCRIPTION = "Davinci (and OMAP) Multimedia Application Interface"
DEPENDS = "virtual/kernel codec-engine"
LICENCE = "unknown"

require ti-paths.inc

# https://www-a.ti.com/downloads/sds_support/applications_packages/dmai/dmai_1_20_00_06/dmai_setuplinux_1_20_00_06.bin
# Install the above link and put the dmai_1_20_00_06.tar.gz file in the same directory as this recipe
SRC_URI = "file://dmai_1_20_00_06.tar.gz \
	   file://update-cpu-name.patch;patch=1 \
	   file://update-fb-display.patch;patch=1 \
	   file://update-v4l2-display.patch;patch=1 \
	   file://do-not-panic-on-mixer-failure.patch;patch=1 \
	   file://support-32bit-align.patch;patch=1 \
#	   file://resizer-fix.patch;patch=1 \
	   file://built-with-angstrom.patch;patch=1 \
          "

S = "${WORKDIR}/dmai_1_20_00_06"
# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "120"

PACKAGE_ARCH = "${MACHINE_ARCH}"

TARGET = "all"
TARGET_neuros-osd2 = " dm6446_al dm6446_db"
TARGET_beagleboard = " o3530_al"

export CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/cetools"

do_compile() {
	cd packages/ti/sdo/dmai
	oe_runmake clean
	oe_runmake ${TARGET} C_FLAGS="-O2 -I${STAGING_INCDIR}"
	cd apps
	oe_runmake clean
	oe_runmake ${TARGET}
}

do_install () {
	oe_runmake install
}

do_stage () {
	:
}
