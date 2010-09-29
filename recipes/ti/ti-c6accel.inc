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

COMPATIBLE_MACHINE = "(da850-omapl138-evm|omap3evm|dm37x-evm)"

PROVIDES += "ti-c6accel-apps"

PR = "r12"

S = "${WORKDIR}/c6accel_${PV}"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/c6000/web/c6accel/latest/exports//c6accel_${PV}_Linux-x86_Setup.bin;name=c6accelbin "

BINFILE="c6accel_${PV}_Linux-x86_Setup.bin"
TI_BIN_UNPK_CMDS="Y:workdir"

DEPENDS = "ti-codec-engine ti-xdais ti-dsplink ti-dspbios" 
DEPENDS += "ti-edma3lld ti-cgt6x ti-xdctools ti-framework-components" 
DEPENDS += "ti-biosutils" 

do_compile() {
    unset VERBOSE
    # Build C6Accel package
    cd ${S}
    make \
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
    all

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

