require ti-multimedia-common.inc

export PLATFORM

export CROSS_COMPILE = "${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}"

# This tells codec engine which targets to build
#DEVICES ?= "DM6446"
#DEVICES_omap3 = "OMAP3530"
#DEVICES_dm6446 = "DM6446"

DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_dm6446 = "DAVINCI"

PLATFORM ?= "dm6446"
PLATFORM_dm6446 = "dm6446"
PLATFORM_dm6467 = "dm6467"

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

export DSPLINK = "${LINK_INSTALL_DIR}/dsplink"

installdir = "${datadir}/ti"

