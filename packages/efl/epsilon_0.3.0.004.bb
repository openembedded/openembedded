DESCRIPTION = "Epsilon is a flexable and powerful image thumbnailing library \
that is complient with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "GPL"
DEPENDS = "edje epeg libpng virtual/imlib2"

inherit efl

SRC_URI += "file://compile-fix.patch;patch=1"
