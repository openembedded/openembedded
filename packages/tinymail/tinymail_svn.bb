SECTION = "x11/utils"
DEPENDS = "gtk+ glib-2.0 gnome-vfs-dbus libgnomeui eds-dbus"
DESCRIPTION = "TinyMail is an attempt to create an E-mail client for mobile devices"
LICENSE = "GPL"
MAINTAINER = "Patrick Steiner <patrick.steiner@a1.net>"

PV = "0.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://svn.cronos.be/svn/tinymail;module=trunk;proto=https"

inherit pkgconfig autotools
S = "${WORKDIR}/trunk"

