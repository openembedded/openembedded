DESCRIPTION = "Galago is a desktop presence framework, designed to transmit presence information between programs."
HOMEPAGE = "http://www.galago-project.org/"
LICENSE = "GPL"
DEPENDS = "gettext libgalago dbus glib-2.0"
PR = "r1"

SRC_URI = "http://www.galago-project.org/files/releases/source/${PN}/${P}.tar.gz \
           file://no-check.patch;patch=1"
EXTRA_OECONF =	"--disable-binreloc"

FILES_${PN} += "${datadir}/dbus-1/services/"

inherit autotools pkgconfig


SRC_URI[md5sum] = "958ea4a9e1be61cb5e5f35f75a9bfede"
SRC_URI[sha256sum] = "958ae2ddc89d218e7b3fe4f00a61f4ade48c8fefa768854c67425f5495387eed"
