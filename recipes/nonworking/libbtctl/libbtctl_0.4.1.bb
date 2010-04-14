DESCRIPTION = "Bluetooth helper library for Glib/GTK/GNOME applications"
HOMEPAGE = "http://usefulinc.com/software/gnome-bluetooth/"
LICENSE="GPLv2"

DEPENDS = "glib-2.0 bluez-libs"

SRC_URI = "http://downloads.usefulinc.com/libbtctl/libbtctl-0.4.1.tar.gz"

SRC_URI[md5sum] = "7c858214d32d76e45a87b34dd885df37"
SRC_URI[sha256sum] = "56b103a9692a7388c86e7f19a9991f464a4d55af4ed8f732b523ab2596c393a2"

inherit pkgconfig autotools
