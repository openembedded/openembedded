export IMAGE_BASENAME = "nylon-base"
 
NYLON_BASE = "base-files base-passwd bash busybox \
	ipkg initscripts less \
	modutils modutils-initscripts mtd-utils \
	nano ncurses netbase \
	openssh sysvinit \
	timezones tinylogin"

DEPENDS = "virtual/kernel \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_DEPENDS}"
	
RDEPENDS = "kernel modutils-depmod modutils-modinfo \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS}"

export IPKG_INSTALL = "${RDEPENDS}" 

IMAGE_LINGUAS = ""

# we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND = "rm -f ${IMAGE_ROOTFS}/tmp/zImage*"

inherit image_ipk
LICENSE = MIT
