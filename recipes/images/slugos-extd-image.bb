# This describes the SlugOS Extended image, which includes everything
# that is in the standard NSLU2 image, with a few extra drivers.  This
# image is usually used with other IXP4xx machines, such as the D-Link
# DSM-G600A and the Iomega NAS100D.

DESCRIPTION = "SlugOS Extended image"

PR = "r3"

require slugos-image.inc

IMAGE_NAME = "${IMAGE_BASENAME}-extd-${DISTRO_VERSION}-${MACHINE}"
IMAGE_LINK_NAME = "${IMAGE_BASENAME}-extd-${MACHINE}"
DEPENDS += "task-slugos-extd"
IMAGE_INSTALL += "task-slugos-extd"

inherit dsmg600-image nas100d-image
