LICENSE     = "LiPS"
DESCRIPTION = "Phone services server"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "dbus-glib glib-2.0  libmsgenabler libabenabler"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

SRC_URI_append_x86 = " file://changeport.patch;patch=1;pnum=0"
SRC_URI_append_fic-gta01 = " file://phoneserver-gta01.patch;patch=1"

