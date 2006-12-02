SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPL"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"
PR = "r5"

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "19"
HHV     = "0"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
           file://defconfig"

require linux-handhelds-2.6.inc

