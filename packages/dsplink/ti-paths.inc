# To build the DSP applications you need to have DSP/BIOS, xdctools and codegen installed. Get these from:
# https://www-a.ti.com/downloads/sds_support/targetcontent/bios/bios_5_33/sabios-j05/bios_setuplinux_5_33_02.bin
# https://www-a.ti.com/downloads/sds_support/targetcontent/rtsc/xdctools_3_10_03/exports/xdctools_setuplinux_3_10_03.bin
# <url for codegen>

# Path to the dir where the TI tools are unpacked
TITOOLSDIR ?= "/OE/TI"
# Path under TITOOLSDIR where dspbios is unpacked
TIBIOSDIR ?= "bios_5_33_02"
TIXDCTOOLSDIR ?= "${TITOOLSDIR}/xdctools_3_10_03"
# Path under TITOOLSDIR where the dsp toolchain is unpacked
TICGTOOLSDIR ?= "cg6x_6_0_16"

DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_omap5912osk = "OMAP"
DSPLINKPLATFORM_beagleboard = "OMAP3530"
DSPLINKPLATFORM_omap3evm = "OMAP3530"
DSPLINKPLATFORM_davinci-sffsdr = "DAVINCI"
DSPLINKPLATFORM_davinci-dvevm = "DAVINCI"

DSPLINKDSP ?= "C64XX"

DSPLINKSOC ?= "DM6446"
DSPLINKSOC_beagleboard = "3530"
DSPLINKSOC_omap3evm = "3530"

DSPCFG ?= "DM6446GEMSHMEM"
DSPCFG_beagleboard ?= "OMAP3530SHMEM"
DSPCFG_omap3evm ?= "OMAP3530SHMEM"

GPPOS ?= "MVL5G"
GPPOS_beagleboard = "OMAPLSP"
GPPOS_omap3evm = "OMAPLSP"

export DSPLINKPLATFORM
export DSPLINKDSP
export DSPLINKSOC
export DSPCFG
export GPPOS

DSPPOWERSOC ?= "dm6446"
DSPPOWERSOC_beagleboard = "omap3530"
DSPPOWERSOC_omap3evm = "omap3530"

