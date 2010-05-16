require linux.inc

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r14"

COMPATIBLE_MACHINE = "htcnexus|htcleo"

SRCREV = "ee54d02485711f2c96db4a8f1f4a43c0bead736c"

SRC_BRANCH = "htc-msm-2.6.32"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
