SRC_URI = "http://svn.opensync.org/releases/opensync-${PV}.tar.gz"

LICENSE = "LGPL"
DEPENDS = "sqlite3 dbus"

inherit autotools pkgconfig

