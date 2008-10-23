# Path to the dir where the TI tools are unpacked
TITOOLSDIR ?= "/OE/TI"
# Path under TITOOLSDIR where dspbios is unpacked
TIBIOSDIR ?= "bios_5_32_04"
TIXDCTOOLSDIR ?= "${TITOOLSDIR}/xdctools_3_10_02"
# Path under TITOOLSDIR where the dsp toolchain is unpacked
TICGTOOLSDIR ?= "cg6x_6_0_19"

DSPLINKPLATFORM ?= "DAVINCI"
DSPLINKPLATFORM_omap5912osk = "OMAP"
DSPLINKPLATFORM_beagleboard = "OMAP3530"
DSPLINKPLATFORM_davinci-sffsdr = "DAVINCI"
DSPLINKPLATFORM_davinci-dvevm = "DAVINCI"

DSPLINKDSP ?= "C64XX"

DSPLINKSOC ?= "DM6446"
DSPLINKSOC_beagleboard = "3530"

DSPCFG ?= "DM6446GEMSHMEM"
DSPCFG_beagleboard ?= "OMAP3530SHMEM"

GPPOS ?= "MVL5G"
GPPOS_beagleboard = "OMAPLSP"

export DSPLINKPLATFORM
export DSPLINKDSP
export DSPLINKSOC
export DSPCFG
export GPPOS

DSPPOWERSOC ?= "dm6446"
DSPPOWERSOC_beagleboard = "omap3530"

