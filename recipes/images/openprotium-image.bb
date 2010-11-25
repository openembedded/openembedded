DESCRIPTION = "OpenProtium image"
HOMEPAGE = "http://www.openprotium.com"

DEPENDS = "task-openprotium"
IMAGE_INSTALL = "task-openprotium"
IMAGE_LINGUAS = ""

IMAGE_NAME = "${IMAGE_BASENAME}-${MACHINE}-${DISTRO_VERSION}"
PACKAGE_REMOVE = "kernel-image-* task-openprotium"

USE_DEVFS = "1"
OPENPROTIUM_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-minimal-add-md.txt')}"
EXTRA_IMAGECMD_jffs2 += " -D ${OPENPROTIUM_DEVICE_TABLE}"

IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${OPENPROTIUM_DEVICE_TABLE} ${IMAGE_ROOTFS}/etc/device_table;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^id:5:initdefault:,id:3:initdefault:, ${IMAGE_ROOTFS}/etc/inittab;" 
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^root::0,root:BTMzOOAQfESg6:0, ${IMAGE_ROOTFS}/etc/passwd;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^VERBOSE=no,VERBOSE=very, ${IMAGE_ROOTFS}/etc/default/rcS;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,^VOLATILE_ENABLE_CACHE=yes,VOLATILE_ENABLE_CACHE=no, ${IMAGE_ROOTFS}/etc/default/rcS;"
IMAGE_PREPROCESS_COMMAND += "sed -i -es,/dev/tty0,/dev/console, ${IMAGE_ROOTFS}/etc/init.d/populate-volatile.sh;"
IMAGE_PREPROCESS_COMMAND += "echo /dev/md >> ${IMAGE_ROOTFS}/etc/udev/mount.blacklist;"
IMAGE_PREPROCESS_COMMAND += "echo /dev/hd >> ${IMAGE_ROOTFS}/etc/udev/mount.blacklist;"
IMAGE_PREPROCESS_COMMAND += "echo /dev/mtd3		0x30000		0x10000		0x10000 > ${IMAGE_ROOTFS}/etc/fw_env.config;"

ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image concatenated-image
