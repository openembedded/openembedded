inherit image
inherit nylon-image

IMAGE_FSTYPES = "jffs2 tar.gz"

export IMAGE_BASENAME = "nylon-base"
 
NYLON_BASE = "base-files base-passwd bash busybox \
	ipkg initscripts less \
	madwifi-modules \
	mtd-utils \
	nylon-scripts \
	nano ncurses netbase \
	openssh \
	pciutils \
	sysvinit \
	tinylogin \
	tzdata \
	wireless-tools wlan-ng-utils"

DEPENDS += "virtual/kernel less nano"

## kernel 2.4 ##
NYLON_IMAGE_RDEPENDS_mtx-1 = " modutils modutils-initscripts modutils-depmod modutils-modinfo"
NYLON_IMAGE_RDEPENDS_mtx-2 = " modutils modutils-initscripts modutils-depmod modutils-modinfo"
## kernel 2.6 ##
NYLON_IMAGE_RDEPENDS_mtx-3 = " module-init-tools udev"
NYLON_IMAGE_RDEPENDS_mtx-3a = " module-init-tools"

RDEPENDS_append = ${NYLON_IMAGE_RDEPENDS}

IMAGE_INSTALL = "kernel less nano elvis-tiny \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS} ${NYLON_IMAGE_RDEPENDS}"

IMAGE_LINGUAS = ""

# we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND = "rm -f ${IMAGE_ROOTFS}/tmp/*Image*"
# needed?? the above line is the same as in classes/nylon-image.bbclass
