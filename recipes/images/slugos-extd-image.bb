# This describes the SlugOS Extended image, which includes everything
# that is in the standard NSLU2 image, with a few extra drivers.  This
# image is usually used with other IXP4xx machines, such as the D-Link
# DSM-G600A and the NAS100D

DESCRIPTION = "SlugOS Extended image"

PR = "r1"

require slugos-image.inc

IMAGE_NAME = "${IMAGE_BASENAME}-extd-${DISTRO_VERSION}"
DEPENDS += "task-slugos-extd"
IMAGE_INSTALL += "task-slugos-extd"

# Todo: fix these image creation tools
#inherit dsmg600-image nas100d-image
