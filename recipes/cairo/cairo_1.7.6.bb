require cairo.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/snapshots/cairo-${PV}.tar.gz \
#           file://configure_fix.patch;patch=1 \
          "



SRC_URI[md5sum] = "c612f581b18903b0751a171685fc38dd"
SRC_URI[sha256sum] = "5268faa116a48a68dd74abb245b26b20f1729d3bd56a8414e429904eb1bae124"
