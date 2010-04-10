DESCRIPTION =	"GNOME Power Manager manages powersettings via HAL and dbus"
LICENSE =	"GPL"
HOMEPAGE =	"http://gnome-power.sourceforge.net/index.php"

SRC_URI = 	"${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
DEPENDS =	"hal dbus gconf libwnck libgnomeui libglade"

inherit autotools

SRC_URI[md5sum] = "db310dadcc958a781a2752a6a7748e60"
SRC_URI[sha256sum] = "78f7dc6946e178513202f06afc19496c8ac1e3ac6c43c56c40f4db1a23762179"
