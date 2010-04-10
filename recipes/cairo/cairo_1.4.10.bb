require cairo.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
file://stats.patch;patch=1;p=1"

PR = "r0"


SRC_URI[md5sum] = "5598a5e500ad922e37b159dee72fc993"
SRC_URI[sha256sum] = "594e78a66044898c321e378d47faf43b665b23ba638834d2787e344ba13e5132"
