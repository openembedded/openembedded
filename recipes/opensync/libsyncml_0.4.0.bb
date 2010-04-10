DESCRIPTION = "Libsyncml is a implementation of the SyncML protocol."
HOMEPAGE = "http://libsyncml.opensync.org/"
LICENSE = "LGPL"

DEPENDS = "sed-native wbxml2 libsoup libxml2 bluez-libs openobex"

SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/${P}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-http \
  		 --enable-obex \
  		 --enable-bluetooth \
    		 --enable-tools \
		 --with-wbxml"

CFLAGS += "-I${STAGING_INCDIR}/libsoup-2.2"

do_configure_append() {
        sed -i s:-I/usr/include/:-I/foo/:g Makefile
        sed -i s:-I/usr/include/:-I/foo/:g */Makefile
	sed -i s:-I/usr/include/:-I/foo/:g */*/Makefile
}


PACKAGES += "${PN}-tools"

FILES_${PN}-tools = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"






SRC_URI[md5sum] = "a6b5becd4b61e246ed2ee95db9f6e746"
SRC_URI[sha256sum] = "2be78a947bdbfd24aa4f35ae97d2b7bafa60162c5e824cf3dd085b40eddee8ff"
