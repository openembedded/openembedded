DESCRIPTION = "DVTB for TI ARM/DSP processors"
SECTION = "multimedia"
LICENSE = "TI"

PR = "r14"
 
DEPENDS = "virtual/kernel alsa-lib ti-framework-components ti-codec-engine ti-xdctools ti-linuxutils alsa-lib jpeg ncurses ti-xdais "

DEPENDS_append_dm365 = "ti-codecs-dm365"
DEPENDS_append_omap3 = "ti-codecs-omap3530"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvtb/${PV_dot}/exports/dvtb_${PV}.tar.gz;name=dvtbtarball \
  file://make-include-rules.make-conditional.patch \
  file://loadmodules-ti-dvtb-${DVTBPLATFORM}.sh \
"


S = "${WORKDIR}/dvtb_${PV}"

require ti-paths.inc
require ti-staging.inc

DVTBPLATFORM_dm365    = "dm365"
DVTBPLATFORM_omap3    = "omap3530"
DVTBPLATFORM          ?= "DVTBPLATFORM_UNDEFINED"

do_compile () {
	cd ${S}
	make clean
	make PLATFORM=${DVTBPLATFORM} \
		VERBOSE="true" \
		DMAI_INSTALL_DIR="${DMAI_INSTALL_DIR}" \
		XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
		CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
		FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
		CODEC_INSTALL_DIR="${CODEC_INSTALL_DIR}" \
		CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
		BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}"\
		CROSS_COMPILE="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
		XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
		LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
		CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
		LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
		LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
		LINUXLIBS_INSTALL_DIR="${STAGING_DIR_TARGET}/usr" \
		MVTOOL_DIR="${TOOLCHAIN_PATH}" \
		CSTOOL_DIR="${TOOLCHAIN_PATH}" \
		MVTOOL_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
		CSTOOL_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
		${DVTBPLATFORM}
}

do_install () {
        install -d ${D}${DVTB_INSTALL_DIR_RECIPE}
        cp -pPrf ${S}/* ${D}${DVTB_INSTALL_DIR_RECIPE}

        # DVTB does not currently support make install, so copying files manually.
        install -d ${D}/${installdir}/dvtb
		# on OMAP3 platform, dvtb bins are found under linux directory
		if [ "${DVTBPLATFORM}" = "omap3530" ]; then
	        cp ${S}/packages/ti/sdo/dvtb/${DVTBPLATFORM}/linux/bin/* ${D}/${installdir}/dvtb
		else
	        cp ${S}/packages/ti/sdo/dvtb/${DVTBPLATFORM}/bin/* ${D}/${installdir}/dvtb

		fi

        # Copy demos' loadmodules.sh into dvtb directory
		if [ -f ${WORKDIR}/loadmodules-ti-dvtb-${DVTBPLATFORM}.sh ]; then
        install -m 0755 ${WORKDIR}/loadmodules-ti-dvtb-${DVTBPLATFORM}.sh ${D}/${installdir}/dvtb/loadmodules.sh
		fi

        # Copy dvtb example scripts into dvtb directory
        install -d ${D}/${installdir}/dvtb/scripts
        cp ${S}/packages/ti/sdo/dvtb/scripts/${DVTBPLATFORM}/* ${D}/${installdir}/dvtb/scripts
}

pkg_postinst_${PN} () {
	ln -sf ${installdir}/ti-codecs-server/*.${DSPSUFFIX} ${installdir}/dvtb/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_ti-dvtb_dm6467 += "ti-cmem-module alsa-lib jpeg"
RDEPENDS_ti-dmai-apps_omap3     += "ti-codecs-omap3530-server ti-cmem-module ti-dsplink-module ti-lpm-module ti-sdma-module alsa-lib jpeg"
RDEPENDS_ti-dvtb_dm355  += "ti-dm355mm-module ti-cmem-module alsa-lib jpeg"
RDEPENDS_ti-dvtb_dm365  += "ti-dm365mm-module ti-cmem-module alsa-lib jpeg"

FILES_${PN} = "${installdir}/dvtb/*"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = "True"
