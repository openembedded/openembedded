# To build the DSP applications you need to have DSP/BIOS, xdctools and codegen installed. Get these from:
# https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/sabios-j05/bios_setuplinux_5_33_02.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/rtsc/xdctools_3_10_03/exports/xdctools_setuplinux_3_10_03.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/LinuxDspTools/download.html
# Back link for above:
# https://www-a.ti.com/downloads/sds_support/targetcontent/index.html

# export some more variable to point to external TI tools
# information is duplicated between the js and make based tools
# needed for configuro:
export CGTOOLS_V5T="${CROSS_DIR}"
export CC_V5T="bin/${TARGET_PREFIX}gcc"
export MVTOOL_PREFIX="${TARGET_PREFIX}"
export MVTOOL_DIR="${CROSS_DIR}"
export CSTOOL_PREFIX="${TARGET_PREFIX}"
export CSTOOL_DIR="${CROSS_DIR}"
export LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}

export PLATFORM

export CROSS_COMPILE = "${CROSS_DIR}/bin/${TARGET_PREFIX}"

# This tells codec engine which targets to build
DEVICES ?= "DM6446"
DEVICES_omap5912osk = "fixme-ti-paths.inc"

# Set a default for armv7a now, change this when omap4 and friends become available
DEVICES_armv7a = "OMAP3530"

DEVICES_davinci-sffsdr = "DM6446"
DEVICES_davinci-dvevm = "DM6446"

DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_omap5912osk = "OMAP"

DSPLINKPLATFORM_davinci-sffsdr = "DAVINCI"
DSPLINKPLATFORM_davinci-dvevm = "DAVINCI"

PLATFORM ?= "dm6446"
PLATFORM_omap5912osk = "OMAP"

PLATFORM_davinci-sffsdr = "dm6446"
PLATFORM_davinci-dvevm = "dm6446"

DSPLINKDSP ?= "C64XX"

DSPLINKSOC ?= "DM6446"

DSPCFG ?= "DM6446GEMSHMEM"

GPPOS ?= "MVL5G"

export DEVICES
export DSPLINKPLATFORM
export DSPLINKDSP
export DSPLINKSOC
export DSPCFG
export GPPOS
export PLATFORM
export LPMDSPPOWERSOC

DSPPOWERSOC ?= "dm6446"

export BIOS_INSTALL_DIR = "${STAGING_DIR_NATIVE}/ti-dspbios-native"
export CE_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine"
export CMEM_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export CODEGEN_INSTALL_DIR = "${STAGING_DIR_NATIVE}/ti-cgt6x-native"
export CROSS_COMPILE = "${CROSS_DIR}/bin/${TARGET_PREFIX}"
export DMAI_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dmai"
export FC_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export LINK_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dsplink-module"
export LINUXKERNEL_INSTALL_DIR = "${STAGING_KERNEL_DIR}" 
export LPM_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-engine/cetools"
export XDC_INSTALL_DIR = "${STAGING_DIR_NATIVE}/ti-xdctools-native"
export XDAIS_INSTALL_DIR = "${CE_INSTALL_DIR}/cetools"

export CODEC_INSTALL_DIR = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo"
export CODEC ?= "${CODEC_INSTALL_DIR}"

export DSPLINK = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dsplink-module/packages/dsplink/"

installdir = "${datadir}/ti"

