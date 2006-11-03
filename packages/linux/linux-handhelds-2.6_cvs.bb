SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA based devices."
LICENSE = "GPL"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"
PR = "r5"

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "17"
HHV     = "2"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
           file://24-hostap_cs_id.diff;patch=1 \
           file://hrw-pcmcia-ids-r2.patch;patch=1 \
           file://defconfig"

require linux-handhelds-2.6.inc

