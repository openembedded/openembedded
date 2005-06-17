SECTION = "x11/utils"
DEPENDS = "gtk+ glib-2.0 dbus libxml2 popt"
DESCRIPTION = "Settings daemon using DBUS for communication (osso version)."
LICENSE = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
PROVIDES = "gconf"
RPROVIDES = "gconf"

PR = "r1"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/g/gconf2/gconf2_${PV}.tar.gz \
           file://gconf-update.patch;patch=1;pnum=0 \
           file://gconf-daemon-oe.sh"

S = "${WORKDIR}/gconf2-2.6.4/GConf-2.6.4"


inherit pkgconfig autotools

FILES_${PN} += "${sysconfdir} ${libdir}/dbus-1.0/ ${libdir}/GConf ${datadir}/sgml"

EXTRA_OECONF = " --with-ipc=dbus --disable-gtk-doc --enable-gtk --host=${HOST_SYS} --enable-shared --disable-static"

HEADERS = "gconf.h gconf-changeset.h gconf-listeners.h gconf-schema.h gconf-value.h gconf-error.h gconf-engine.h gconf-client.h gconf-enum-types.h"

do_install_append () {
	install -d ${D}/${sysconfdir}/osso-af-init
	install -m755 ${WORKDIR}/gconf-daemon-oe.sh ${D}${sysconfdir}/osso-af-init/gconf-daemon.sh
	install -d ${D}${sysconfdir}/osso-af-init/gconf-dir
	install -d ${D}/var/lib/gconf
}

do_stage() {
        oe_libinstall -so -C gconf libgconf-2 ${STAGING_LIBDIR}
        install -d ${STAGING_INCDIR}/gconf/2/gconf/
        ( cd gconf; for i in ${HEADERS}; do install -m 0644 $i ${STAGING_INCDIR}/gconf/2/gconf/$i; done )
        install -m 0644 gconf.m4 ${STAGING_DATADIR}/aclocal/gconf-2.m4
}
