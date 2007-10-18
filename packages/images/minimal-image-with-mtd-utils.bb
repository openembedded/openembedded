# this image was created for use with the compulab cm-x270 platform
# for creating a small initramfs image in NOR flash that can be used
# to program the NAND flash.

require minimal-image.bb
IMAGE_INSTALL += "mtd-utils"

export IMAGE_BASENAME = "minimalist-image-mtdutils"

