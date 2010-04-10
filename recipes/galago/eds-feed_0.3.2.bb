DESCRIPTION = "Galago linkage to the Evolution Data Server."
HOMEPAGE = "http://www.galago-project.org/"
LICENSE = "GPL"
DEPENDS = "gettext libgalago dbus glib-2.0 eds-dbus"

SRC_URI = "http://www.galago-project.org/files/releases/source/${PN}/${P}.tar.gz \
           file://disable-bonobo.patch;patch=1"
#           file://no-check.patch;patch=1"
#EXTRA_OECONF =	"--disable-binreloc"

FILES_${PN} += "${libdir}/galago/eds-feed"

inherit autotools pkgconfig


SRC_URI[md5sum] = "1f6ac4910dc8bb0276549bd0308f8acb"
SRC_URI[sha256sum] = "6b7448359284f5af75cbb7027c47616b28aca8b90f9a16b9ec954fa50e455ed3"
