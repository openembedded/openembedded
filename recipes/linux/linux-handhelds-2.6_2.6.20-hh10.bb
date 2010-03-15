SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPLv2"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

# Override where to look for defconfigs and patches,
# we have per-kernel-release sets.
FILESPATH = "${FILE_DIRNAME}/linux-handhelds-2.6-2.6.20/${MACHINE}:${FILE_DIRNAME}/linux-handhelds-2.6-2.6.20"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://defconfig"

require linux-handhelds-2.6.inc
