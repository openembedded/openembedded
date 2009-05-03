# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).

HOMEPAGE = "http://www.nslu2-linux.org"

DEPENDS = "task-slugos"
IMAGE_INSTALL = "task-slugos"

COMPATIBLE_MACHINE = "nslu2|ixp4xx|sheevaplug"

IMAGE_NAME = "${IMAGE_BASENAME}-${DISTRO_VERSION}"
IMAGE_LINK_NAME = "${IMAGE_BASENAME}-${MACHINE}"
IMAGE_FSTYPES = "jffs2 tar.gz"
IMAGE_DEVICE_TABLES = "files/device_table-slugos.txt"
IMAGE_LINGUAS = ""

# IMAGE_PREPROCESS_COMMAND is run before making the image.  In SlugOS the
# kernel image is removed from the root file system to recover the space used -
# SlugOS is assumed to boot from a separate kernel image in flash (not in the
# root file system), if this is not the case the following must not be done!
IMAGE_PREPROCESS_COMMAND += "rm -f ${IMAGE_ROOTFS}/boot/?Image*;"

inherit image
