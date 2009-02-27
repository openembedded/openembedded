DESCRIPTION = "Davinci (and OMAP) Multimedia Application Interface"
DEPENDS = "virtual/kernel ti-codec-engine ti-codec-combos"
LICENCE = "unknown"

require ti-paths.inc

# https://www-a.ti.com/downloads/sds_support/applications_packages/dmai/dmai_1_20_00_06/dmai_setuplinux_1_20_00_06.bin
# Install the above link and put the dmai_1_20_00_06.tar.gz file in the same directory as this recipe
SRC_URI = "file://dmai_1_20_00_06.tar.gz \
	   file://dmai-update-cpu-name.patch;patch=1 \
	   file://dmai-update-fb-display.patch;patch=1 \
	   file://dmai-update-v4l2-display.patch;patch=1 \
	   file://dmai-do-not-panic-on-mixer-failure.patch;patch=1 \
	   file://dmai-support-32bit-align.patch;patch=1 \
	   file://dmai-built-with-angstrom.patch;patch=1 \
           file://loadmodules-ti-dmai-apps.sh \
           file://unloadmodules-ti-dmai-apps.sh \
   "

S = "${WORKDIR}/dmai_1_20_00_06"
# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "120"
PR = "r14"

TARGET = "all"
TARGET_neuros-osd2 = " dm6446_al dm6446_db"
TARGET_beagleboard = " o3530_al"
TARGET_omap3evm = " o3530_al"

export CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine"
export FC_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export CODEC_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos"

do_compile_prepend_omap3evm() {

#temp removal of sources that fail to build on evm3530
	if [ -e packages/ti/sdo/dmai/linux/omap3530/Resize.c ]; then
		rm packages/ti/sdo/dmai/linux/omap3530/Resize.c
	fi

        if [ -e packages/ti/sdo/dmai/linux/omap3530/Framecopy_accel.c ]; then
                rm packages/ti/sdo/dmai/linux/omap3530/Framecopy_accel.c
        fi
}

do_compile() {
	cd packages/ti/sdo/dmai
	oe_runmake clean
	oe_runmake ${TARGET} C_FLAGS="-O2 -I${STAGING_INCDIR}"
	cd apps
	oe_runmake clean
	oe_runmake ${TARGET}
}

do_install () {
	install -d ${D}/${datadir}/ti-dmai/apps

	export EXEC_DIR="${D}/${datadir}/ti-dmai/apps"
	oe_runmake install

    #test app module un/load scripts
        install ${WORKDIR}/loadmodules-ti-dmai-apps.sh ${D}/${datadir}/ti-dmai
        install ${WORKDIR}/unloadmodules-ti-dmai-apps.sh ${D}/${datadir}/ti-dmai
}

do_stage () {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dmai
	cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dmai
}

PACKAGES =+ "ti-dmai-apps"

ALLOW_EMPTY_${PN} = "1"
RRECOMMENDS_${PN} = "ti-dmai-apps"

FILES_ti-dmai-apps = "${datadir}/ti-dmai/*"

pkg_postinst_ti-dmai-apps () {
        if [ -n "$D" ]; then
                exit 1
        fi
	ln -sf /usr/share/ti-codec-combos/* /usr/share/ti-dmai/apps
}

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#add run-time dependencies - note for kernel module we can only use RRECOMMENDS, since modules might be built into the kernel
# and for now we make codecs RRECOMMENDS as well, since not everyone will have them
#RDEPENDS_ti-dmai-apps += "ti-codec-combos"
RRECOMMENDS_ti-dmai-apps += "ti-cmem-module ti-lpm-module ti-dsplink-module ti-codec-combos"

