LICENSE =	"LGPL"
MAINTAINER=	"Koen Kooi <koen@handhelds.org>"

DEPENDS =	"libx11 dbus libosso"
SRC_URI =	"http://stage.maemo.org:80/pool/maemo/ossw/source/o/osso-af-utils/osso-af-utils_${PV}-1.tar.gz"

inherit autotools pkgconfig

