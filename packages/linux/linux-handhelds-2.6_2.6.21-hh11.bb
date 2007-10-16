SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPL"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://defconfig"

SRC_URI_append_ghi270 = " file://ghi270-hh11.patch;patch=1"

require linux-handhelds-2.6.inc
