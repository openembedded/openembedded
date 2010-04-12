DESCRIPTION = "Libsyncml is a implementation of the SyncML protocol."
HOMEPAGE = "http://libsyncml.opensync.org/"
LICENSE = "LGPL"
DEPENDS = "sed-native wbxml2 libsoup libxml2 bluez-libs openobex"

SRC_URI = "http://libsyncml.opensync.org/download/releases/${PV}/libsyncml-${PV}.tar.bz2 \
           file://build-in-src.patch;patch=1"

inherit cmake pkgconfig

do_stage() {
        autotools_stage_all
}

PACKAGES += "${PN}-tools"

FILES_${PN}-tools = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"

SRC_URI[md5sum] = "d524b18c1eafe5805f83e29c01a91b66"
SRC_URI[sha256sum] = "818740eb5df3cf7913ab7e7979874ccf403831744c89efa4ebaf74c7e2c090bc"
