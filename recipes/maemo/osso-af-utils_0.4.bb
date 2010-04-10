LICENSE =	"LGPL"

DEPENDS =	"virtual/libx11 dbus libosso"
SRC_URI =	"http://stage.maemo.org:80/pool/maemo/ossw/source/o/osso-af-utils/osso-af-utils_${PV}-1.tar.gz"

inherit autotools pkgconfig


SRC_URI[md5sum] = "8a10a5b3bb494d8bc2241fd041f0e4d4"
SRC_URI[sha256sum] = "6a92a4bb2876fdfb7454723f0235ce9962f72cf41938aed58b1b49562c693a77"
