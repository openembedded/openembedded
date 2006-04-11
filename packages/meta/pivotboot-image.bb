export IMAGE_BASENAME = "pivotboot-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-pivotboot"

DEPENDS = "task-pivotboot"
PR = "r1"

inherit image_ipk

FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11 \
                               opie##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/opie"

LICENSE = "MIT"
