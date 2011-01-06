DESCRIPTION = "TI C6Accel - DSP Software Libraries on ARM"
HOMEPAGE = "https://gforge01.dal.design.ti.com/gf/project/dsplib4arm/"

SECTION = "devel"
LICENSE = "TI TSPA"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

PLATFORM_omapl138 = "omapl138"
PLATFORM_omap3 = "omap3530"
PLATFORM ?= "<UNDEFINED_PLATFORM>"

COMPATIBLE_MACHINE = "(omapl138|omap3)"

PROVIDES += "ti-c6accel-apps"

# This recipe links statically against kernel dependant stuff, use kernel PR as base and append a local version
PR = "${MACHINE_KERNEL_PR}"
PR_append = "c"

S = "${WORKDIR}/c6accel_${PV}"

# http://software-dl.ti.com/dsps/dsps_public_sw/c6000/web/c6accel/latest/index_FDS.html
SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/c6000/web/c6accel/latest/exports//c6accel_${PV}_Linux-x86_Setup.bin;name=c6accelbin "

BINFILE="c6accel_${PV}_Linux-x86_Setup.bin"
TI_BIN_UNPK_CMDS="Y:workdir"

DEPENDS = "ti-codec-engine ti-xdais ti-dsplink ti-dspbios" 
DEPENDS += "ti-edma3lld ti-cgt6x ti-xdctools ti-framework-components" 
DEPENDS += "ti-biosutils" 

TIARGS = ' \
    PLATFORM="${PLATFORM}" \
    CE_INSTALL_DIR="${CE_INSTALL_DIR}" \
    XDAIS_INSTALL_DIR="${XDAIS_INSTALL_DIR}" \
    LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
    CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
    EDMA3_LLD_INSTALL_DIR="${EDMA3_LLD_INSTALL_DIR}" \
    CODEGEN_INSTALL_DIR="${CODEGEN_INSTALL_DIR}" \
    XDC_INSTALL_DIR="${XDC_INSTALL_DIR}" \
    FC_INSTALL_DIR="${FC_INSTALL_DIR}" \
    BIOS_INSTALL_DIR="${BIOS_INSTALL_DIR}" \
    BIOSUTILS_INSTALL_DIR="${BIOSUTILS_INSTALL_DIR}" \
    LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
    SERVER_INSTALL_DIR="${CODEC_INSTALL_DIR}" \
    C6ACCEL_INSTALL_DIR="${S}" \
    CSTOOL_DIR="${TOOLCHAIN_PATH}" \
    CSTOOL_PREFIX="${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}" \
    LINUXLIBS_INSTALL_DIR="${STAGING_DIR}/${BASE_PACKAGE_ARCH}${HOST_VENDOR}-${HOST_OS}" \
    CFLAGS=" ${TARGET_CC_ARCH} ${CFLAGS}" LDFLAGS="${LDFLAGS}" \
'

do_configure() {
	unset VERBOSE
	make ${TIARGS} clean
	sed -i -e 's:-L$(LINUXLIBS_INSTALL_DIR)/lib:-L$(LINUXLIBS_INSTALL_DIR)/lib -L$(LINUXLIBS_INSTALL_DIR)/usr/lib ${LDFLAGS}:' ${S}/soc/app/Makefile

	# Angstrom 2008 breaks with -Wl,-T, while angstrom 2010 needs it
	if [ $(${TARGET_PREFIX}gcc -dumpversion | awk -F. '{print $2}') -gt 3 ] ; then
		sed -i -e 's: $(XDC_CFG)/linker.cmd: -Wl,-T,$(XDC_CFG)/linker.cmd:g' ${S}/soc/app/Makefile
	fi
}

do_compile() {
    unset VERBOSE
    make ${TIARGS} all
}

do_install() {
    install -d ${D}${C6ACCEL_INSTALL_DIR_RECIPE}
    cp -pPrf ${S}/* ${D}${C6ACCEL_INSTALL_DIR_RECIPE}

    # update linker.cmd file to point to sysroot 
    sed -i ${i} -e s=${S}=${C6ACCEL_INSTALL_DIR}=g ${D}${C6ACCEL_INSTALL_DIR_RECIPE}/soc/app/c6accel_app_config/linker.cmd

    cd ${S} 
    make \
      PLATFORM="${PLATFORM}" \
      CMEM_INSTALL_DIR="${CMEM_INSTALL_DIR}" \
      LINK_INSTALL_DIR="${LINK_INSTALL_DIR}" \
      LPM_INSTALL_DIR="${LPM_INSTALL_DIR}" \
      C6ACCEL_INSTALL_DIR="${S}" \
      EXEC_DIR_C6ACCEL="${D}/${installdir}/c6accel-apps" \
      install
}

PACKAGES += "ti-c6accel-apps"
FILES_ti-c6accel-apps = "${installdir}/c6accel-apps/*"
INSANE_SKIP_ti-c6accel-apps = True
RDEPENDS_ti-c6accel-apps += "ti-cmem-module ti-dsplink-module"

