# OpenSlug Kernel for NSLU2
#
# The only purpose to this is to allow the openslug kernel to
# have an openslug specific defconfig - in openslug-kernel-${PV}
include nslu2-kernel_${PV}.bb
# Increment the following if the openslug-kernel defconfig is
# changed.
PR_CONFIG = "1"
