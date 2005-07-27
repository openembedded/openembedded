DESCRIPTION = "Bluetooth helper library for Glib/GTK/GNOME applications"
HOMEPAGE = "http://usefulinc.com/software/gnome-bluetooth/"
LICENSE="GPLv2"

DEPENDS = "glib-2.0 bluez-libs"

SRC_URI = "http://downloads.usefulinc.com/libbtctl/libbtctl-0.4.1.tar.gz"

inherit pkgconfig autotools
