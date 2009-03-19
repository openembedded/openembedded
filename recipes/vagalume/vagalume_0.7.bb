DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://people.igalia.com/berto/"
SECTION = "x11"
DEPENDS = "gtk+ gstreamer"
RRECOMMENDS = "dbus-x11"
PR = "r0"

SRC_URI = "\
  http://garage.maemo.org/frs/download.php/4505/vagalume_${PV}.orig.tar.gz\
"
S = "${WORKDIR}/vagalume-${PV}.orig"

inherit autotools
