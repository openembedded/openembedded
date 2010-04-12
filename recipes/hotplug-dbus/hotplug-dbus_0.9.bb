PR = "r1"
SECTION = "base"
DESCRIPTION = "D-BUS glue for hotplug system"
# DEPENDS = "dbus hotplug"
DEPENDS = "dbus"
RDEPENDS = "hotplug"
LICENSE = "GPL"

inherit gpe

SRC_URI[md5sum] = "75245aa9adc5acb9d6ac8eae45533c96"
SRC_URI[sha256sum] = "96144ffbb24f23acd3615594344902a3fad241bc05127d38e5dde8df300c27c0"
