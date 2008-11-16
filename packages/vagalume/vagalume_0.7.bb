DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://people.igalia.com/berto/"
SECTION = "x11"
DEPENDS = "gtk+ gstreamer"
PR = "r0"

SRC_URI = "\
  http://people.igalia.com/berto/files/vagalume/source/vagalume_${PV}.orig.tar.gz \
"
S = "${WORKDIR}/vagalume-${PV}.orig"

inherit autotools
