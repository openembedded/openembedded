SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPL"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

# Override where to look for defconfigs and patches,
# we have per-kernel-release sets.
FILESPATH = "${FILE_DIRNAME}/linux-handhelds-2.6-2.6.21/${MACHINE}:${FILE_DIRNAME}/linux-handhelds-2.6-2.6.21"

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "21"
HHV     = "20"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26  \
           file://defconfig"

require linux-handhelds-2.6.inc

