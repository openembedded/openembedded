DESCRIPTION = "gio is a platform independent file and I/O abstraction library"
LICENSE = "LGPL"
DEPENDS = "glib-2.0"
PR = "r1"

inherit gnome

PACKAGES =+ "libgio"
FILES_libgio = "${libdir}/libgio.so.*"

SRC_URI[archive.md5sum] = "6c3ae062f5b32f20eeaf91603f92652e"
SRC_URI[archive.sha256sum] = "a142efdd4508c7af90db878ded6f4713eb9bca47b508f60b294e62d7905ecff2"
