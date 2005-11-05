LICENSE = 	""
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

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
	
