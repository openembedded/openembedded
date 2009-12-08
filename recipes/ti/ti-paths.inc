# To build the DSP applications you need to have DSP/BIOS, xdctools and codegen installed. Get these from:
# https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/sabios-j05/bios_setuplinux_5_33_02.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/rtsc/xdctools_3_10_03/exports/xdctools_setuplinux_3_10_03.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/LinuxDspTools/download.html
# Back link for above:
# https://www-a.ti.com/downloads/sds_support/targetcontent/index.html

# export some more variable to point to external TI tools
# information is duplicated between the js and make based tools

require ti-multimedia-common.inc

export PLATFORM

export CROSS_COMPILE = "${CROSS_DIR}/bin/${TARGET_PREFIX}"

# This tells codec engine which targets to build
DEVICES ?= "DM6446"
DEVICES_omap3 = "OMAP3530"
DEVICES_dm6446 = "DM6446"

DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_dm6446 = "DAVINCI"

PLATFORM ?= "dm6446"
PLATFORM_dm6446 = "dm6446"

DSPLINKDSP ?= "C64XX"

DSPLINKSOC ?= "DM6446"

DSPCFG ?= "DM6446GEMSHMEM"

GPPOS ?= "LINUX_GCC"

export DEVICES
export DSPLINKPLATFORM
export DSPLINKDSP
export DSPLINKSOC
export DSPCFG
export GPPOS
export PLATFORM
export LPMDSPPOWERSOC

DSPPOWERSOC ?= "dm6446"

export CODEC ?= "${CODEC_INSTALL_DIR}"

export DSPLINK = "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-dsplink-module/packages/dsplink/"

installdir = "${datadir}/ti"

