LICENSE = 	""

DEPENDS =	"dbus gconf glib-2.0 libosso bluez-libs"

SRC_URI = 	"http://repository.maemo.org/pool/maemo/ossw/source/o/osso-gwconnect/osso-gwconnect_${PV}.tar.gz \
			file://osso-gwconnect-stdio.patch;patch=1"

EXTRA_OECONF = 	"--disable-mce"

FILES_${PN} += "${libdir}/dbus-1.0/services/"

inherit pkgconfig autotools

do_stage() {
    install -d ${STAGING_INCDIR}
    install -m 644 src/*.h ${STAGING_INCDIR}
}


SRC_URI[md5sum] = "e4a87e616807dfd8557663a28990e948"
SRC_URI[sha256sum] = "1bebf4c6adf9d383014bf0da8f133c0dbb6aa420033347e8e1f307f79051bc86"
