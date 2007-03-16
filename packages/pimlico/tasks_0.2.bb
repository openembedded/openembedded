DESCRIPTION = "Tasks is a simple TODO application."
SECTION = "x11"
LICENSE = "LGPL"
PR = "r0"

DEPENDS = "glib-2.0 gtk+ libglade eds-dbus"

SRC_URI = "http://projects.o-hand.com/sources/tasks/${P}.tar.gz"

inherit autotools pkgconfig gtk-icon-cache


