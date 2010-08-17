DESCRIPTION = "Evolution database backend server"
HOMEPAGE = "http://labs.o-hand.com/embedded-eds/"
LICENSE = "LGPL"
DEPENDS = "libical intltool-native libglade glib-2.0 gtk+ gconf dbus db gnome-common virtual/libiconv zlib intltool libxml2 libsoup-2.4"

SRCREV = "91812cd2f797fb8ec8befbb2685037584ce144ee"
PV = "1.4.0"
PR = "r5"
PE = "1"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://git.o-hand.com/eds-dbus;branch=master;protocol=git \
           file://iconv-detect.h \
           file://libxml2-for-libedataserverui.patch \
           file://gtk-doc.make"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

# -ldb needs this on some platforms
LDFLAGS += "-lpthread"

do_configure_prepend () {
     cp ${WORKDIR}/iconv-detect.h ${S}
     cp ${WORKDIR}/gtk-doc.make ${S}
}

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:-I${includedir}::g $i
	done
}
EXTRA_OECONF = "--without-openldap --with-dbus --without-weather --without-bug-buddy --without-soup --without-libdb --with-libdb=${STAGING_DIR_HOST}${layout_prefix} --disable-smime --disable-nss --disable-nntp --disable-gtk-doc --enable-calendar --disable-hula --disable-dot-locking --disable-gnome-keyring"

PACKAGES =+ "libcamel-collateral libcamel libcamel-dev libebook libebook-dev libecal libecal-dev libedata-book libedata-book-dev libedata-cal libedata-cal-dev libedataserver libedataserver-dev"

FILES_${PN} =+ "${datadir}/evolution-data-server-*/glade/*.glade"

FILES_${PN}-dev =+ "${libdir}/pkgconfig/evolution-data-server-*.pc"
FILES_${PN}-dbg =+ "${libdir}/evolution-data-server-*/camel-providers/.debug ${libdir}/evolution-data-server*/extensions/.debug/"

FILES_libcamel = "${libdir}/libcamel-*.so.* ${libexecdir}/camel-*"
FILES_libcamel-dev = "${libdir}/libcamel-*.so ${libdir}/libcamel-provider-*.so ${libdir}/pkgconfig/camel*pc ${includedir}/evolution-data-server*/camel"
FILES_libcamel-collateral = "${libdir}/libcamel-provider-*.so.* ${libdir}/evolution-data-server-*/camel-providers/*.so ${libdir}/evolution-data-server-*/camel-providers/*.urls"

FILES_libebook = "${libdir}/libebook-*.so.*"
FILES_libebook-dev = "${libdir}/libebook-1.2.so ${libdir}/pkgconfig/libebook-*.pc ${includedir}/evolution-data-server*/libebook/*.h"
RRECOMMENDS_libebook = "libedata-book"

FILES_libecal = "${libdir}/libecal-*.so.* ${datadir}/evolution-data-server-1.4/zoneinfo"
FILES_libecal-dev = "${libdir}/libecal-*.so ${libdir}/pkgconfig/libecal-*.pc ${includedir}/evolution-data-server*/libecal/*.h ${includedir}/evolution-data-server*/libical/*.h"
RRECOMMENDS_libecal = "libedata-cal tzdata"

FILES_libedata-book = "${libexecdir}/e-addressbook-factory ${datadir}/dbus-1/services/*.AddressBook.service ${libdir}/libedata-book-*.so.* ${libdir}/evolution-data-server-*/extensions/libebook*.so"
FILES_libedata-book-dev = "${libdir}/libedata-book-*.so ${libdir}/pkgconfig/libedata-book-*.pc ${includedir}/evolution-data-server-*/libedata-book"

FILES_libedata-cal = "${libexecdir}/e-calendar-factory ${datadir}/dbus-1/services/*.Calendar.service ${libdir}/libedata-cal-*.so.* ${libdir}/evolution-data-server-*/extensions/libecal*.so"
FILES_libedata-cal-dev = "${libdir}/libedata-cal-*.so ${libdir}/pkgconfig/libedata-cal-*.pc ${includedir}/evolution-data-server-*/libedata-cal"

FILES_libedataserver = "${libdir}/libedataserver-*.so.*"
FILES_libedataserver-dev = "${libdir}/libedataserver-*.so ${libdir}/pkgconfig/libedataserver-*.pc ${includedir}/evolution-data-server-*/libedataserver/*.h"

do_install_append () {
	rm ${D}${libdir}/evolution-data-server-*/*/*.la
}
