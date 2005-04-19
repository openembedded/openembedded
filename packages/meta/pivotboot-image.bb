export IMAGE_BASENAME = "pivotboot-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-pivotboot"

DEPENDS = "task-pivotboot"

inherit image_ipk

FEED_URIS_append_openzaurus = " x11##http://openzaurus.org/official/unstable/3.5.2/feed/x11 \
                                gpe##http://openzaurus.org/official/unstable/3.5.2/feed/gpe \
                               opie##http://openzaurus.org/official/unstable/3.5.2/feed/opie \
                                  e##http://openzaurus.org/official/unstable/3.5.2/feed/e"

FEED_URIS_append_familiar   = " x11##http://familiar.handhelds.org/releases/0.8/feed/x11 \
                               opie##http://familiar.handhelds.org/releases/0.8/feed/opie \

LICENSE = MIT
