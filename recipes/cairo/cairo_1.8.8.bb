PR = "r1"

require cairo.inc

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
           file://dolt-fix.patch;patch=1 \
          "


