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
SRC_URI_append_om-gta01 = " file://phoneserver-gta01.patch;patch=1"


SRC_URI[md5sum] = "6f6450c4e762059e790216b15b5930e6"
SRC_URI[sha256sum] = "a1f05eba12369fb8bafb53559ae5ab2855ab1e83746049a100ce5a6d69bec2a6"
