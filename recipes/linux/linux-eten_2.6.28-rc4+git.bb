require linux.inc

DESCRIPTION = "The Linux kernel for E-Ten Glofiish smartphones"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "eten-m800"

KERNEL_RELEASE = "2.6.28-rc4"
KERNEL_VERSION = "${KERNEL_RELEASE}"

# See http://wiki.openembedded.net/index.php/Versioning_Policy
SRCREV = "ab2d414f4f13816af0ec0401b608133ca946624a"
PV = "2.6.27+${KERNEL_RELEASE}+${PR}+gitr${SRCREV}"
PR = "r2"

SRC_URI = "\
  git://git.openezx.org/gnufiish.git;protocol=git;branch=master \
  file://defconfig \
"
S = "${WORKDIR}/git"

CMDLINE = "root=/dev/mmcblk0p1 rootdelay=5 ro"
