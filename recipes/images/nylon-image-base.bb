inherit image
inherit nylon-image

export IMAGE_BASENAME = "nylon-base"
 
NYLON_BASE = "base-files base-passwd bash busybox \
	ipkg initscripts less \
	mtd-utils \
	nano ncurses netbase \
	openssh sysvinit \
	tzdata tinylogin udev"

DEPENDS += "virtual/kernel less nano"
IMAGE_INSTALL = "kernel less nano elvis-tiny \
	${NYLON_BASE} ${BOOTSTRAP_EXTRA_RDEPENDS}"

## kernel 2.4 ##
RDEPENDS_append_mtx-1 = " modutils modutils-initscripts modutils-depmod modutils-modinfo"
RDEPENDS_append_mtx-2 = " modutils modutils-initscripts modutils-depmod modutils-modinfo"
## kernel 2.6 ##
RDEPENDS_append_mtx-3 = " module-init-tools udev"
RDEPENDS_append_mtx-3a = " module-init-tools"

IMAGE_LINGUAS = ""

# we dont need the kernel in the image
ROOTFS_POSTPROCESS_COMMAND = "rm -f ${IMAGE_ROOTFS}/tmp/*Image*"
# needed?? the above line is the same as in classes/nylon-image.bbclass
