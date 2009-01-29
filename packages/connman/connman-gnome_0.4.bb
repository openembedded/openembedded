DESCRIPTION = "gtk frontend for connman"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "gtk+ dbus"
PR = "r1"

SRC_URI = "ftp://ftp.moblin.org/connman/releases/connman-gnome-${PV}.tar.gz"

inherit autotools gtk-icon-cache

