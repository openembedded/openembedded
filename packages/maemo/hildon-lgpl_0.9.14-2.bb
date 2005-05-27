LICENSE = 	"LGPL"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = "gtk+-2.6.4-1.osso7 outo xtst libmatchbox libxi xt libpng gconf"

SRC_URI = 	"http://repository.maemo.org/pool/maemo/ossw/source/h/hildon-lgpl/hildon-lgpl_${PV}.tar.gz \
			file://hildon-lgpl-noWerror.patch;patch=1"

S =	"${WORKDIR}/hildon-lgpl-0.9.14"
EXTRA_OECONF =	"--enable-shared --disable-gtk-doc"

inherit pkgconfig autotools

FILES_${PN} += " ${libdir}/outo/*.so" 

do_install_prepend() {
	install -d ${D}/${libdir}
	install hildon-lgpl/.libs/libhildonlgpl.so.0.4.0 ${D}/${libdir}/libhildonlgpl.so

}

do_stage() {
	install -d ${STAGING_INCDIR}/hildon-widgets
	install -d ${STAGING_LIBDIR}
	install -m 644 hildon-lgpl/*.h ${STAGING_INCDIR}/hildon-widgets
	install  hildon-lgpl/.libs/libhildonlgpl.so.0.4.0 ${STAGING_LIBDIR}/libhildonlgpl.so
}
