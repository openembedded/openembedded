require mtd-utils.inc

DEPENDS += "e2fsprogs-libs"

PARALLEL_MAKE = ""
ARM_INSTRUCTION_SET = "arm"

# This is the default package, thus we lock to a specific git version so 
# upstream changes will not break builds.

TAG = "v${PV}"

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git;tag=${TAG} \
	   file://add-exclusion-to-mkfs-jffs2-git-2.patch;patch=1 \
	   file://fix-ignoreerrors-git.patch;patch=1 \
	   file://lzo_1x-git.patch;patch=1"

S = "${WORKDIR}/git/"

do_configure_prepend() {
	for i in $(find . -name "Makefile") ; do
		sed -i -e s:lzo2:lzo:g $i
	done
	if [ -e mkfs.ubifs/compr.c ]; then
		sed -i -e s:lzo/::g mkfs.ubifs/compr.c
	fi
}
