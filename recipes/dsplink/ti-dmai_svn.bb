DESCRIPTION = "Davinci (and OMAP) Multimedia Application Interface"
DEPENDS = "virtual/kernel ti-codec-engine ti-codec-combos"
LICENCE = "unknown"

require ti-paths.inc

SRC_URI = "svn://gforge.ti.com/svn/dmai/branches;module=BRIJESH_GIT_022309;proto=https;user=anonymous;pswd='' \
	   file://dmai-built-with-angstrom.patch;patch=1 \
           file://loadmodules-ti-dmai-apps.sh \
           file://unloadmodules-ti-dmai-apps.sh \
   "

SRCREV = "36"

S = "${WORKDIR}/BRIJESH_GIT_022309/davinci_multimedia_application_interface/dmai"
# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "120+svnr${SRCREV}"
PR = "r16"

TARGET = "all"
TARGET_neuros-osd2 = " dm6446_al dm6446_db"

TARGET_armv7a = " o3530_al"

TARGET_beagleboard = " o3530_al"
TARGET_omap3evm = " o3530_al"

export CE_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine"
export FC_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export CODEC_INSTALL_DIR="${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combos"

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

