PR = "r1"
SECTION = "base"
DESCRIPTION = "D-BUS glue for hotplug system"
# DEPENDS = "dbus hotplug"
DEPENDS = "dbus"
MAINTAINER = "Phil Blundell <pb@debian.org>"
RDEPENDS = "hotplug"
LICENSE = "GPL"

inherit gpe
