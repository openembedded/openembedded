DESCRIPTION = "Foonas image"
LICENSE = "GPL"
PR = "r0"

inherit image n2100-image turbostation-image lsppchg-image lsppchd-image storcenter-image

DEPENDS = "${MACHINE_TASK_PROVIDER} makedevs-native mtd-utils-native"

EXTRA_IMAGECMD_jffs2 += " --pad --eraseblock=${ERASEBLOCK_SIZE} -D ${FOONAS_DEVICE_TABLE}"
IMAGE_LINGUAS = ""

RDEPENDS = " \
	base-files base-passwd netbase \
        busybox initscripts foonas-init \
        update-modules sysvinit tinylogin \
	module-init-tools-depmod modutils-initscripts \
        ipkg-collateral ipkg ipkg-link \
	libgcc1 diffutils cpio findutils\
	dropbear e2fsprogs-blkid \
	mdadm hdparm mtd-utils udev \
	${FOONAS_SUPPORT} \
	${FOONAS_KERNEL} "

PACKAGE_INSTALL = "${RDEPENDS}"

