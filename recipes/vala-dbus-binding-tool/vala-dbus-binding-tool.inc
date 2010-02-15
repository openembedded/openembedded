DESCRIPTION = "Vala DBus Binding Tool"
SECTION = "devel"
DEPENDS = "vala libgee libxml2 intltool-native"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/vala-dbus-binding-tool"
LICENSE = "GPLv2"
INC_PR = "r1"

SRC_URI = "http://www.freesmartphone.org/sources/vala-dbus-binding-tool-${PV}.tar.bz2;name=archive"

inherit autotools_stage

BBCLASSEXTEND = "native"
