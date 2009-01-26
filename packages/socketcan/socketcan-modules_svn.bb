DESCRIPTION = "Socketcan kernel modules"
HOMEPAGE = "http://developer.berlios.de/projects/socketcan/"
SECTION = "kernel/modules"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
PV = "0.0+svnr${SRCREV}"

SRC_URI = "svn://svn.berlios.de/socketcan/trunk;module=kernel;proto=svn"

S = "${WORKDIR}/kernel/2.6"

inherit module

#EXTRA_OEMAKE += "KERNELDIR=${KERNEL_SOURCE}"

