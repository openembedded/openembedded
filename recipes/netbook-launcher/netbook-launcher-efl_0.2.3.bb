DESCRIPTION = "This is a version of the netbook-launcher using Enlightenment Foundation Libraries (EFL) so it will run on systems without 3D acceleration required by Clutter."
LICENSE = "GPLv3"

PR = "r1"

DEPENDS = "liblauncher libxau dbus-glib gtk+ libgnome libgnomeui edje edje-native libnotify libcanberra evas eina ecore elementary eet"
RDEPENDS_${PN} = "evas-loader-svg"

inherit gnome

SRC_URI = "http://launchpad.net/launch-lite-proj/0.2/${PV}/+download/netbook-launcher-efl-${PV}.tar.gz"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"


SRC_URI[md5sum] = "d38cd496c427ba240ac20770939bee70"
SRC_URI[sha256sum] = "182b97e9b2f230ee9bf378ca0d62ec8a033acbf882d7cbd94b9a1d94d3d305de"
