LICENSE     = "LiPS"
DESCRIPTION = "Phone services server"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

DEPENDS = "dbus-glib glib-2.0  libmsgenabler libabenabler"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

SRC_URI += "file://changeport.patch;patch=1;pnum=0"

