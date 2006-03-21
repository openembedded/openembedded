export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-bootstrap"

DEPENDS = "task-bootstrap"
PR = "r1"

inherit image_ipk

FEED_URIS_append_openzaurus = " \
                      opie##${FEED_BASE_URI}/feed/opie \
                      x11##${FEED_BASE_URI}/feed/x11 "

FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11 \
                               opie##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/opie"

LICENSE = MIT
