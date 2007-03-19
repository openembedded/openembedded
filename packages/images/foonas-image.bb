DESCRIPTION = "Foonas image"
LICENSE = "GPL"
PR = "r0"

inherit image

DEPENDS = "${MACHINE_TASK_PROVIDER} makedevs-native mtd-utils-native"

IMAGE_PREPROCESS_COMMAND += "sed -i -es,^id:5:initdefault:,id:3:initdefault:, ${IMAGE_ROOTFS}/etc/inittab;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^root::0,root:BTMzOOAQfESg6:0, ${IMAGE_ROOTFS}/etc/passwd;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^VERBOSE=no,VERBOSE=very, ${IMAGE_ROOTFS}/etc/default/rcS;"
FOONAS_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-slugos.txt')}"
EXTRA_IMAGECMD_jffs2 += " --eraseblock=${ERASEBLOCK_SIZE} -D ${FOONAS_DEVICE_TABLE}"
IMAGE_LINGUAS = ""

RDEPENDS = " \
	base-files base-passwd netbase \
        busybox initscripts foonas-init \
        update-modules sysvinit tinylogin \
	module-init-tools-depmod modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	libgcc1 diffutils cpio findutils\
	portmap dropbear e2fsprogs-blkid \
	mdadm hdparm mtd-utils udev \
	${FOONAS_SUPPORT} \
	${FOONAS_KERNEL} "

PACKAGE_INSTALL = "${RDEPENDS}"

inherit n2100-image turbostation-image lsppchg-image lsppchd-image