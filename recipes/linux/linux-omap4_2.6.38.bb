COMPATIBLE_MACHINE = "omap4"

# Needs a lot of work :(
DEFAULT_PREFERENCE = "-1"

require multi-kernel.inc

# The main PR is now using MACHINE_KERNEL_PR, for omap4 see conf/machine/include/omap4.inc
MACHINE_KERNEL_PR_append = "a"

CORTEXA8FIXUP = "no"

SRCREV = "fcc80daf58da014a9828944fce0668a1a3792445"

SRC_URI = "git://kernel.ubuntu.com/rsalveti/ubuntu-natty.git;protocol=git;branch=ti-omap4-drm2 \
           file://defconfig"

S = "${WORKDIR}/git"
