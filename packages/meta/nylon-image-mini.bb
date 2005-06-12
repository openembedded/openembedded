export IMAGE_BASENAME = "nylon-base"
 
NYLON_BASE = "base-files base-passwd busybox \
	miniinit \
	netbase \
	wireless-tools"

DEPENDS = "virtual/kernel \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_DEPENDS}"
	
RDEPENDS = "kernel \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS}"

export IPKG_INSTALL = "${RDEPENDS}" 

IMAGE_LINGUAS = ""

# we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND = "rm -f ${IMAGE_ROOTFS}/boot/zImage*"

inherit image_ipk
LICENSE = "MIT"
