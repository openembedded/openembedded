DESCRIPTION = "Kf is a GTK+ instant messaging client."
LICENSE = "GPL"
DEPENDS = "libxml2 glib-2.0 gtk+ loudmouth"
PR = "r3"

SRC_URI = "http://jabberstudio.2nw.net/${PN}/${PN}-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           file://fix-desktop-file.patch;patch=0 \
           file://gcc4.patch;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-binreloc"

export PKG_CONFIG="${STAGING_BINDIR_NATIVE}/pkg-config"


SRC_URI[md5sum] = "f963f289b7a1221f192a540fbda5cd55"
SRC_URI[sha256sum] = "70068af405b4a18c84babded6a1d3fee1b87687d725c1c0456570f06c3841ef3"
