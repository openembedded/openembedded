require mtd-utils.inc

DEPENDS += "util-linux-ng lzo2"

PARALLEL_MAKE = ""
ARM_INSTRUCTION_SET = "arm"

# This is the default package, thus we lock to a specific git version so 
# upstream changes will not break builds.

TAG = "v${PV}"

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git;tag=${TAG} \
	   file://add-exclusion-to-mkfs-jffs2-git-2.patch \
	   file://fix_heap_corruption.patch \
	  "

S = "${WORKDIR}/git/"
