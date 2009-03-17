DESCRIPTION =	"GNOME Power Manager manages powersettings via HAL and dbus"
LICENSE =	"GPL"
HOMEPAGE =	"http://gnome-power.sourceforge.net/index.php"

SRC_URI = 	"${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"
DEPENDS =	"hal dbus gconf libwnck libgnomeui libglade"

inherit autotools
