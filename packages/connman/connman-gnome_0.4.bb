DESCRIPTION = "gtk frontend for connman"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "gtk+ dbus"

SRC_URI = "ftp://ftp.moblin.org/connman/releases/connman-gnome-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "/usr/share/icons"

