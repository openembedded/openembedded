require linux.inc

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r15"

COMPATIBLE_MACHINE = "htcnexus|htcleo"

SRCREV = "bc796399c0a19622b8aa1f705d841c9b4059550b"

SRC_BRANCH = "htc-msm-2.6.32"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
