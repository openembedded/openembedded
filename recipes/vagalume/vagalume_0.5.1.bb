DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://people.igalia.com/berto/"
SECTION = "x11"
DEPENDS = "gtk+"
PR = "r1"

SRC_URI = "\
  http://people.igalia.com/berto/files/vagalume/source/vagalume_0.5.1-1.tar.gz \
  file://use-png-icons.patch;patch=1 \
"

inherit autotools
