export IMAGE_BASENAME = "pivotboot-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-pivotboot"

DEPENDS = "task-pivotboot"

inherit image_ipk

FEED_URIS_append_openzaurus = " x11##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/x11 \
                                gpe##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/gpe \
                               opie##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/opie \
                                  e##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/e"

FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/x11 \
                               opie##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/opie"

LICENSE = "MIT"

IMAGE_FSTYPES_append_spitz = " jffs2"
