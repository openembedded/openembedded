SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for PXA based devices."
LICENSE = "GPL"
PR = "r1"

FILESPATH = "${FILE_DIRNAME}/linux-handhelds-2.6-2.6.16/${MACHINE}:${FILE_DIRNAME}/linux-handhelds-2.6-2.6.16"

require linux-handhelds-2.6.inc
