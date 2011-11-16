require mtd-utils.inc

DEPENDS += "util-linux-ng lzo2"

PARALLEL_MAKE = ""
ARM_INSTRUCTION_SET = "arm"
DEFAULT_PREFERENCE = "1"

# This is the default package, thus we lock to a specific git version so
# upstream changes will not break builds.

SRCREV = "7df62e8e9bb1f77ca0890cc757bd20a6f33a7fbc"

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git"

S = "${WORKDIR}/git/"
