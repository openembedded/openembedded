# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).
#
DESCRIPTION = "Generic SlugOS image"
HOMEPAGE = "http://www.nslu2-linux.org"

DEPENDS = "task-slugos"
IMAGE_INSTALL = "task-slugos"

COMPATIBLE_MACHINE = "nslu2"

IMAGE_NAME = "${IMAGE_BASENAME}-${DISTRO_VERSION}"
IMAGE_FSTYPES = "jffs2 tar.gz"
EXTRA_IMAGECMD_jffs2 += " -D ${SLUGOS_DEVICE_TABLE}"
IMAGE_LINGUAS = ""

# Setting USE_DEVFS prevents *any* entries being created initially
# in /dev
USE_DEVFS = "1"

# This is passed to the image command to build the correct /dev
# directory (because only the image program can make actual
# dev entries!)
SLUGOS_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-slugos.txt')}"

# IMAGE_PREPROCESS_COMMAND is run before making the image.  In SlugOS the
# kernel image is removed from the root file system to recover the space used -
# SlugOS is assumed to boot from a separate kernel image in flash (not in the
# root file system), if this is not the case the following must not be done!
IMAGE_PREPROCESS_COMMAND += "rm ${IMAGE_ROOTFS}/boot/zImage*;"
IMAGE_PREPROCESS_COMMAND += "install -c -m 644 ${SLUGOS_DEVICE_TABLE} ${IMAGE_ROOTFS}/etc/device_table;"

inherit image nslu2-image
