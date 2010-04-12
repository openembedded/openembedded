DESCRIPTION = "DVSDK Demo applications for TI ARM/DSP processors"
SECTION = "multimedia"
LICENSE = "TI"

INC_PR = "r1"

DEPENDS += "ti-dmai"
DEPENDS += "alsa-lib libpng freetype jpeg"

SRC_URI = "${BASE_SRC_URI}/dvsdk_demos_${PV}.tar.gz;name=dvsdkdemostarball"

S = "${WORKDIR}/dvsdk_demos_${PV}"

require ti-paths.inc

DEMOSPLATFORM_dm355    = "dm355"
DEMOSPLATFORM_dm365    = "dm365"
DEMOSPLATFORM_dm6446   = "dm6446"
DEMOSPLATFORM_dm6467   = "dm6467"
DEMOSPLATFORM_omap3    = "omap3530"
DEMOSPLATFORM_omapl137 = "ol137"
DEMOSPLATFORM_omapl138 = "ol138"

do_configure_prepend() {
    sed -i -e 's:INSTALLSUBDIRS = $(addsuffix .install, $(SUBDIRS)):INSTALLSUBDIRS = $(addsuffix .install, $(PLATFORM)):g' ${S}/Makefile
}

do_compile () {
	cd ${S}
	make -e clean
	make -e PLATFORM=${DEMOSPLATFORM} \
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
		${DEMOSPLATFORM}
}

do_install () {
	cd ${S}
	make -e EXEC_DIR=${D}/${installdir}/dvsdk-demos \
		PLATFORM=${DEMOSPLATFORM} \
		install
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_ti-dvsdk-demos_dm355 += "ti-dm355mm-module ti-cmem-module alsa-lib libpng freetype jpeg"
RDEPENDS_ti-dvsdk-demos_dm365 += "ti-dm365mm-module ti-cmem-module alsa-lib libpng freetype jpeg"

FILES_${PN} = "${installdir}/dvsdk-demos/*"

BASE_SRC_URI ?= "http://install.source.dir.local"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = "True"
