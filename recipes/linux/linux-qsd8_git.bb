require linux.inc

PV = "2.6.29+${PR}+gitr${SRCREV}"
PR = "r13"

COMPATIBLE_MACHINE = "htcnexus|htcleo"

SRCREV = "2d3ee40a2d334693c342ef10c5fde599854e91a9"

SRC_BRANCH = "htc-qsd8k-2.6.29"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
