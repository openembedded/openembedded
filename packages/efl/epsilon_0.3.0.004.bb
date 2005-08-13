DESCRIPTION = "Epsilon is a flexable and powerful image thumbnailing library \
that is complient with the freedesktop.org Thumbnail Managing Standard."
LICENSE = "GPL"
DEPENDS = "virtual/imlib2 epeg libpng virtual/evas virtual/ecore perl-native edje"

inherit efl

SRC_URI += "file://compile-fix.patch;patch=1"
