require linux.inc

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r15"

COMPATIBLE_MACHINE = "htcnexus|htcleo"

SRCREV = "01e2c3f2662d5da31bcf5498381509fbb1e6b40f"

SRC_BRANCH = "htc-msm-2.6.32"

SRC_URI = "\
  git://git.linuxtogo.org/home/groups/mobile-linux/kernel.git;branch=${SRC_BRANCH};protocol=git \
  file://defconfig \
"

S = "${WORKDIR}/git"
