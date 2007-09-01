IMAGE_LINGUAS = ""
USE_DEVFS = "1"

DEPENDS = "nslu2-linksys-kernel"
export IMAGE_BASENAME = "nslu2-linksys"
IMAGE_INSTALL = "nslu2-linksys-ramdisk"

NSLU2_DEVICE_TABLE = "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-nslu2.txt')}"
EXTRA_IMAGECMD_ext2.gz = "-f ${NSLU2_DEVICE_TABLE}"

inherit image
