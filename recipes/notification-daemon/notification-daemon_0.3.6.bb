DESCRIPTION = "A dbus service that listens to desktop notification requests and displays them"
HOMEPAGE = "http://www.galago-project.org/"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "gettext dbus gtk+ libsexy gconf libwnck"
PR = "r1"

SRC_URI = "http://www.galago-project.org/files/releases/source/${PN}/${P}.tar.gz \
           file://dbus-glib-tool-prefix.patch;patch=1"

EXTRA_OECONF = "--disable-binreloc"

inherit autotools pkgconfig

FILES_${PN} = "\
  ${libexecdir}/notification-daemon \
  ${datadir}/dbus-1/services \
  ${libdir}/notification-daemon-1.0/engines/libstandard.so \
  ${sysconfdir}/gconf/schemas/notification-daemon.schemas \
"

SRC_URI[md5sum] = "a5a9aa63205e624da8468e35722b08bf"
SRC_URI[sha256sum] = "a187976c1957a7a0e17014ed97cbb4341f6898d5f60301f1b0c37e52188ebd13"
