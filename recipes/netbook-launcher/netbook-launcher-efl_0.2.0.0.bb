DESCRIPTION = "This is a version of netbook-launcher using Enlightenment Foundation Libraries (EFL) so it would run in systems without 3D acceleration required by Clutter."
LICENSE = "GPLv3"

DEPENDS = "liblauncher libxau dbus-glib gtk+ libgnome libgnomeui edje edje-native libnotify libcanberra evas eina ecore elementary eet"

inherit gnome

SRC_URI = "http://launchpad.net/launch-lite-proj/trunk/alpha-0.2.0/+download/netbook-launcher-efl-${PV}.tar.gz"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

