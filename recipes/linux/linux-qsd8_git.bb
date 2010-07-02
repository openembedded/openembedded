require linux.inc

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r15"

COMPATIBLE_MACHINE = "htcnexus|htcleo"

SRCREV = "3aa5467b241e74b1e74f4bdb3766e464b1c39a9d"

SRC_BRANCH = "htc-msm-2.6.32"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
