# To build the DSP applications you need to have DSP/BIOS, xdctools and codegen installed. Get these from:
# https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/sabios-j05/bios_setuplinux_5_33_02.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/rtsc/xdctools_3_10_03/exports/xdctools_setuplinux_3_10_03.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/LinuxDspTools/download.html
# Back link for above:
# https://www-a.ti.com/downloads/sds_support/targetcontent/index.html

# Path to the dir where the TI tools are unpacked
TITOOLSDIR ?= "/OE/TI"
# Path under TITOOLSDIR where dspbios is unpacked
TIBIOSDIR ?= "bios_5_33_02"
TIXDCTOOLSDIR ?= "xdctools_3_10_03"
# Path under TITOOLSDIR where the dsp toolchain is unpacked
TICGTOOLSDIR ?= "cg6x_6_0_16"

# Path to codecs/servers package - this is taken from DVSDK 3.00.00.29
# - This needs fixing to be x-platform (not just omap3)
#TICODECSDIR ?= "omap3530_dvsdk_combos_3_16"

# export some more variable to point to external TI tools
# information is duplicated between the js and make based tools
export CE_INSTALL_DIR=${S}
export XDC_INSTALL_DIR=${TITOOLSDIR}/${TIXDCTOOLSDIR}
export BIOS_INSTALL_DIR=${TITOOLSDIR}/${TIBIOSDIR}
# needed for configuro:
export CGTOOLS_V5T="${CROSS_DIR}"
export CC_V5T="bin/${TARGET_PREFIX}gcc"
export MVTOOL_PREFIX="${TARGET_PREFIX}"
export MVTOOL_DIR="${CROSS_DIR}"
export CSTOOL_PREFIX="${TARGET_PREFIX}"
export CSTOOL_DIR="${CROSS_DIR}"
export LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}

# used by dmai (and gstreamer_ti?)
#export CODEC_INSTALL_DIR=${TITOOLSDIR}/${TICODECSDIR}

# This tells codec engine which targets to build
DEVICES ?= "DM6446"
DEVICES_omap5912osk = "fixme-ti-paths.inc"

# Set a default for armv7a now, change this when omap4 and friends become available
DEVICES_armv7a = "OMAP3530"

DEVICES_omap3evm = "OMAP3530"
DEVICES_beagleboard = "OMAP3530"
DEVICES_davinci-sffsdr = "DM6446"
DEVICES_davinci-dvevm = "DM6446"

DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_omap5912osk = "OMAP"

# Set a default for armv7a now, change this when omap4 and friends become available
DSPLINKPLATFORM_armv7a = "OMAP3530"

DSPLINKPLATFORM_beagleboard = "OMAP3530"
DSPLINKPLATFORM_omap3evm = "OMAP3530"
DSPLINKPLATFORM_davinci-sffsdr = "DAVINCI"
DSPLINKPLATFORM_davinci-dvevm = "DAVINCI"

PLATFORM ?= "dm6446"
PLATFORM_omap5912osk = "OMAP"

# Set a default for armv7a now, change this when omap4 and friends become available
PLATFORM_armv7a = "omap3530"

PLATFORM_beagleboard = "omap3530"
PLATFORM_omap3evm = "omap3530"
PLATFORM_davinci-sffsdr = "dm6446"
PLATFORM_davinci-dvevm = "dm6446"

DSPLINKDSP ?= "C64XX"

# Set a default for armv7a now, change this when omap4 and friends become available
DSPLINKSOC_armv7a = "3530"

DSPLINKSOC ?= "DM6446"
DSPLINKSOC_beagleboard = "3530"
DSPLINKSOC_omap3evm = "3530"

DSPCFG ?= "DM6446GEMSHMEM"

# Set a default for armv7a now, change this when omap4 and friends become available
DSPCFG_armv7a ?= "OMAP3530SHMEM"

DSPCFG_beagleboard ?= "OMAP3530SHMEM"
DSPCFG_omap3evm ?= "OMAP3530SHMEM"

GPPOS ?= "MVL5G"

# Set a default for armv7a now, change this when omap4 and friends become available
GPPOS_armv7a = "OMAPLSP"

GPPOS_beagleboard = "OMAPLSP"
GPPOS_omap3evm = "OMAPLSP"

export DEVICES
export DSPLINKPLATFORM
export DSPLINKDSP
export DSPLINKSOC
export DSPCFG
export GPPOS
export PLATFORM

# Set a default for armv7a now, change this when omap4 and friends become available
DSPPOWERSOC_armv7a = "omap3530"

DSPPOWERSOC ?= "dm6446"
DSPPOWERSOC_beagleboard = "omap3530"
DSPPOWERSOC_omap3evm = "omap3530"

