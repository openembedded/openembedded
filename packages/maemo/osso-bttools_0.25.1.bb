LICENSE =	"LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS =	"dbus glib-2.0 libosso bluez-libs"

SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/o/osso-bttools/osso-bttools_${PV}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0/services/"
