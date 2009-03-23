# Note that this package is intended to create an *identical*
# kernel and rootfs as the normal base-image.bb

# The only reason for the existence of this .bb file is to
# create the 8MB and 16MB flashable NSLU2 firmware images.

# Please do not add anything other than the following two
# lines to this file, and please do not do anything in
# the nslu2-image class which might affect the kernel
# or rootfs.

require base-image.bb

inherit nslu2-image
