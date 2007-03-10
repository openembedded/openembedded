DESCRIPTION = "An Internet printing system for Unix."
SECTION = "console/utils"
LICENSE = "GPL LGPL"
DEPENDS = "gnutls jpeg dbus dbus-glib libpng zlib install-native fakeroot-native"
PR = "r1"

SRC_URI = "ftp://ftp3.easysw.com/pub/cups/${PV}/cups-${PV}-source.tar.bz2 \
	  "

inherit autotools binconfig

LDFLAGS += " -L${STAGING_LIBDIR} "

EXTRA_OECONF = " \
                --enable-gnutls \
		--enable-dbus \
		--enable-browsing \
                --disable-openssl \
		--disable-tiff \
		--without-php \
		--without-perl \
		--without-python \
		--without-java \
               "


do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_compile () {
	sed -i s:STRIP:NOSTRIP: Makedefs
	sed -i s:serial:: backend/Makefile

	echo "all:"    >  man/Makefile
	echo "install:" >> man/Makefile

	oe_runmake "SSLLIBS=-lgnutls -L${STAGING_LIBDIR}" \
		   "LIBPNG=-lpng -lm -L${STAGING_LIBDIR}" \
		   "LIBJPEG=-ljpeg -L${STAGING_LIBDIR}" \
		   "LIBZ=-lz -L${STAGING_LIBDIR}" \
		   "-I."
}

fakeroot do_install () {
	oe_runmake "DSTROOT=${D}" install
}

do_stage () {
	install -d ${STAGING_INCDIR}/cups
	install ${S}/cups/*.h ${STAGING_INCDIR}/cups/
	install ${S}/filter/*.h ${STAGING_INCDIR}/cups/
	oe_libinstall -C cups -so libcups ${STAGING_LIBDIR}
	oe_libinstall -C filter -so libcupsimage ${STAGING_LIBDIR}
}

FILES_${PN}-dbg += "${libdir}/cups/backend/.debug \
                    ${libdir}/cups/cgi-bin/.debug \
		    ${libdir}/cups/filter/.debug \
		    ${libdir}/cups/monitor/.debug \
		    ${libdir}/cups/notifier/.debug \
		    ${libdir}/cups/daemon/.debug \
		    "
#package the html for the webgui inside the main packages (~1MB uncompressed)

FILES_${PN} += "${datadir}/doc/cups/images \
		${datadir}/doc/cups/*html \
		${datadir}/doc/cups/*.css \
                ${datadir}/icons/ \
	       "




