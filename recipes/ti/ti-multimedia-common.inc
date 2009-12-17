installdir = "${datadir}/ti"

# needed for configuro:
export CGTOOLS_V5T="${CROSS_DIR}"
export CC_V5T="bin/${TARGET_PREFIX}gcc"
export CROSS_COMPILE = "${CROSS_DIR}/bin/${TARGET_PREFIX}"
export MVTOOL_PREFIX="${TARGET_PREFIX}"
export MVTOOL_DIR="${CROSS_DIR}"
export CSTOOL_PREFIX="${TARGET_PREFIX}"
export CSTOOL_DIR="${CROSS_DIR}"
export LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}

export CODEC_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codecs"

export LINUXLIBS_INSTALL_DIR  = "${STAGING_DIR_HOST}/usr"
export CODEGEN_INSTALL_DIR    = "${STAGING_DIR_NATIVE}/ti-cgt6x-native"
export XDC_INSTALL_DIR        = "${STAGING_DIR_NATIVE}/ti-xdctools-native"
export XDAIS_INSTALL_DIR      = "${STAGING_DIR_NATIVE}/ti-xdais"
export BIOS_INSTALL_DIR       = "${STAGING_DIR_NATIVE}/ti-dspbios-native"

export CE_INSTALL_DIR         = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine"
export FC_INSTALL_DIR         = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-framework-components"
export LINUXKERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}"
export LINUXUTILS_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-linuxutils"
export CMEM_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-linuxutils"
#export LINK_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export LINK_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dsplink-module"
export LPM_INSTALL_DIR        = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export DMAI_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dmai"

export USER_XDC_PATH    = "${CE_INSTALL_DIR}/examples"
export XDC_TARGET       = gnu.targets.arm.GCArmv5T

XDC_PLATFORM_dm355   = ti.platforms.evmDM355
XDC_PLATFORM_dm365   = ti.platforms.evmDM365
XDC_PLATFORM_dm6446  = ti.platforms.evmDM6446
XDC_PLATFORM_omap3   = ti.platforms.evm3530
XDC_PLATFORM_omapl137 = ti.platforms.omapl137
XDC_PLATFORM_omapl138 = ti.platforms.omapl138
export XDC_PLATFORM

export PLATFORM_XDC = ${XDC_PLATFORM}

LPMDSPPOWERSOC_omap3  = "omap3530"

export LPMDSPPOWERSOC

PLATFORM_dm355   = "dm355"
PLATFORM_dm365   = "dm365"
PLATFORM_dm6446  = "dm6446"
PLATFORM_omap3   = "omap3530"
PLATFORM_omapl137 = "ol137"
PLATFORM_omapl138 = "ol138"
export PLATFORM

