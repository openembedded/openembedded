LICENSE =	"LGPL"

DEPENDS =	"dbus glib-2.0 libosso bluez-libs"

SRC_URI =	"http://repository.maemo.org/pool/maemo/ossw/source/o/osso-bttools/osso-bttools_${PV}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/dbus-1.0/services/"

SRC_URI[md5sum] = "528eaa3b27b51e9823f2ca4261dc8354"
SRC_URI[sha256sum] = "ad2e75c857888ab6fcb26b45a792729d42d42f3293090bcdb09256eebb0ed8be"
