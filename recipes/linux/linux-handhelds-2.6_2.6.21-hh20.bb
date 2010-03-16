SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPLv2"
PR = "r26"

DEFAULT_PREFERENCE = "-1"

# Override where to look for defconfigs and patches,
# we have per-kernel-release sets.
FILESPATH = "${FILE_DIRNAME}/linux-handhelds-2.6-2.6.21/${MACHINE}:${FILE_DIRNAME}/linux-handhelds-2.6-2.6.21"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://linux-2.6.git-9d20fdd58e74d4d26dc5216efaaa0f800c23dd3a.patch;patch=1 \
           http://www.rpsys.net/openzaurus/patches/archive/export_atags-r0a.patch;patch=1 \
           file://gcc4x-limits.patch;patch=1 \
           file://0001-time-prevent-the-loop-in-timespec_add_ns-from-bei.patch;patch=1 \
	   file://defconfig"

require linux-handhelds-2.6.inc
