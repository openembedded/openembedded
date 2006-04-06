export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-bootstrap"

DEPENDS = "task-bootstrap"

inherit image_ipk

FEED_URIS_append_openzaurus = " x11##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/x11 \
                                gpe##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/gpe \
                               opie##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/opie \
                                  e##http://ewi546.ewi.utwente.nl/mirror/www.openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/e"

LICENSE = MIT
