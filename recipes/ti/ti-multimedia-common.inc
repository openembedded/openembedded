installdir = "${datadir}/ti"

# needed for configuro:
export CGTOOLS_V5T="${TOOLCHAIN_PATH}"
export CC_V5T="bin/${TARGET_PREFIX}gcc"
export CROSS_COMPILE = "${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"
export MVTOOL_PREFIX="${TARGET_PREFIX}"
export MVTOOL_DIR="${TOOLCHAIN_PATH}"
export CSTOOL_PREFIX="${TARGET_PREFIX}"
export CSTOOL_DIR="${TOOLCHAIN_PATH}"
export LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}

export CODEC_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codecs"

export LINUXLIBS_INSTALL_DIR  = "${STAGING_DIR_HOST}/usr"
export LINUXKERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}"

# This is where do_install will put it
export CODEGEN_INSTALL_DIR_RECIPE    = "${installdir}/ti-cgt6x-tree"
export XDC_INSTALL_DIR_RECIPE        = "${installdir}/ti-xdctools-tree"
export XDAIS_INSTALL_DIR_RECIPE      = "${installdir}/ti-xdais-tree"
export BIOS_INSTALL_DIR_RECIPE       = "${installdir}/ti-dspbios-tree"
export BIOSUTILS_INSTALL_DIR_RECIPE  = "${installdir}/ti-biosutils-tree"
export FC_INSTALL_DIR_RECIPE         = "${installdir}/ti-framework-components-tree"

export CE_INSTALL_DIR_RECIPE         = "${installdir}/ti-codec-engine-tree"
export EDMA3_LLD_INSTALL_DIR_RECIPE  = "${installdir}/ti-edma3lld-tree"
export LINUXUTILS_INSTALL_DIR_RECIPE = "${installdir}/ti-linuxutils-tree"
export CMEM_INSTALL_DIR_RECIPE       = "${installdir}/ti-linuxutils-tree"
export LINK_INSTALL_DIR_RECIPE       = "${installdir}/ti-dsplink-tree/packages"
export LPM_INSTALL_DIR_RECIPE        = "${installdir}/ti-local-power-manager-tree"
export DMAI_INSTALL_DIR_RECIPE       = "${installdir}/ti-dmai-tree"

# This is where the tools will end up in staging provided PACKAGE_ARCH = ${MACHINE_ARCH} is set
export CODEGEN_INSTALL_DIR    = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${CODEGEN_INSTALL_DIR_RECIPE}"
export XDC_INSTALL_DIR        = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${XDC_INSTALL_DIR_RECIPE}"
export XDAIS_INSTALL_DIR      = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${XDAIS_INSTALL_DIR_RECIPE}"
export BIOS_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${BIOS_INSTALL_DIR_RECIPE}"
export BIOSUTILS_INSTALL_DIR  = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${BIOSUTILS_INSTALL_DIR_RECIPE}"
export FC_INSTALL_DIR         = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${FC_INSTALL_DIR_RECIPE}"

export CE_INSTALL_DIR         = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${CE_INSTALL_DIR_RECIPE}"
export EDMA3_LLD_INSTALL_DIR  = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${EDMA3_LLD_INSTALL_DIR_RECIPE}"
export LINUXUTILS_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${LINUXUTILS_INSTALL_DIR_RECIPE}"
export CMEM_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${CMEM_INSTALL_DIR_RECIPE}"
export LINK_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${LINK_INSTALL_DIR_RECIPE}"
export LPM_INSTALL_DIR        = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${LPM_INSTALL_DIR_RECIPE}"
export DMAI_INSTALL_DIR       = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}${DMAI_INSTALL_DIR_RECIPE}"

export USER_XDC_PATH    = "${CE_INSTALL_DIR}/examples"
export XDC_TARGET       = gnu.targets.arm.GCArmv5T

XDC_PLATFORM_dm355   = ti.platforms.evmDM355
XDC_PLATFORM_dm365   = ti.platforms.evmDM365
XDC_PLATFORM_dm6446  = ti.platforms.evmDM6446
XDC_PLATFORM_dm6467  = ti.platforms.evmDM6467
XDC_PLATFORM_omap3   = ti.platforms.evm3530
XDC_PLATFORM_omapl137 = ti.platforms.evmOMAPL137
XDC_PLATFORM_omapl138 = ti.platforms.evmOMAPL138
export XDC_PLATFORM

export PLATFORM_XDC = ${XDC_PLATFORM}

DSPSUFFIX_omapl137 = "x674"
DSPSUFFIX_omapl138 = "x674"
DSPSUFFIX ?= "x64P"

PLATFORM_dm355   = "dm355"
PLATFORM_dm365   = "dm365"
PLATFORM_dm6446  = "dm6446"
PLATFORM_dm6467  = "dm6467"
PLATFORM_omap3   = "omap3530"
PLATFORM_omapl137 = "ol137"
PLATFORM_omapl138 = "ol138"
export PLATFORM

