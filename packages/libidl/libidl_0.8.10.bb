require libidl.inc

DEPENDS = "glib-2.0 libidl-native"

FILE_PR = "r0"

BINCONFIG_GLOB = "*-config-2"
inherit autotools pkgconfig binconfig
