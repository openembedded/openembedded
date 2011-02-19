#package the html for the webgui inside the main packages (~1MB uncompressed)
DESCRIPTION = "An Internet printing system for Unix."
SECTION = "console/utils"
LICENSE = "GPL LGPL"
DEPENDS = "gnutls libpng jpeg dbus dbus-glib zlib fakeroot-native"
DEPENDS += "virtual/libusb0"
PROVIDES = "cups14"
PR = "r4"

SRC_URI = "ftp://ftp.easysw.com/pub/cups/${PV}/cups-${PV}-source.tar.bz2 \
           file://use_echo_only_in_init.patch \
           file://skip_tools.patch \
           file://configure.patch \
           file://textonly.ppd \
           file://textonly \
           file://text.convs \
           "
SRC_URI[md5sum] = "8776403ad60fea9e85eab9c04d88560d"
SRC_URI[sha256sum] = "d25ffa35add3abeeec0eba60be2cffc89425b649c64ef3a73dfc724683a59aa3"

DEFAULT_PREFERENCE = "-1"

inherit autotools binconfig

EXTRA_OECONF = "--enable-gnutls \
                --enable-dbus \
                --enable-browsing \
                --disable-openssl \
                --disable-tiff \
                --without-php \
                --without-perl \
                --without-python \
                --without-java \
                --disable-gssapi \
                --disable-largefile \
                --enable-debug \
                --disable-relro \
                --enable-libusb \
                "

do_configure() {
    gnu-configize
    libtoolize --force
    DSOFLAGS="${LDFLAGS}" oe_runconf
}
do_compile () {
    sed -i s:STRIP:NOSTRIP: Makedefs
    sed -i s:serial:: backend/Makefile
    echo "all:"    >  man/Makefile
    echo "libs:" >> man/Makefile
    echo "install:" >> man/Makefile
    echo "install-data:" >> man/Makefile
    echo "install-exec:" >> man/Makefile
    echo "install-headers:" >> man/Makefile
    echo "install-libs:" >> man/Makefile
    oe_runmake "SSLLIBS=-lgnutls -L${STAGING_LIBDIR}" \
               "LIBPNG=-lpng -lm -L${STAGING_LIBDIR}" \
               "LIBJPEG=-ljpeg -L${STAGING_LIBDIR}" \
               "LIBZ=-lz -L${STAGING_LIBDIR}" \
               "-I."
}

PACKAGES =+ "${PN}-lib ${PN}-libimage ${PN}-filter-textonly ${PN}-filters ${PN}-models"

PACKAGES_DYNAMIC += "${PN}-backend-*"

python populate_packages_prepend() {
	backend_dir = bb.data.expand('${libdir}/cups/backend/', d)
	do_split_packages(d, backend_dir, '^(.*)$', 'cups-backend-%s',
	                  '${PN} backend for %s', prepend=True, allow_links=True)
}

FILES_${PN}-lib = "${libdir}/libcups.so.*"
FILES_${PN}-libimage = "${libdir}/libcupsimage.so.*"
FILES_${PN}-filter-textonly += "${datadir}/ppd/cups-included/textonly.ppd \
                                ${datadir}/cups/mime/text.convs \
                                ${libdir}/cups/filter/textonly \
                                "
FILES_${PN}-filters += "${libdir}/cups/filter/*"
FILES_${PN}-models += "${datadir}/cups/model/*"
FILES_${PN}-dbg += "${libdir}/cups/backend/.debug \
                    ${libdir}/cups/cgi-bin/.debug \
                    ${libdir}/cups/filter/.debug \
                    ${libdir}/cups/monitor/.debug \
                    ${libdir}/cups/notifier/.debug \
                    ${libdir}/cups/daemon/.debug \
                    "
FILES_${PN} += "${datadir}/doc/cups/images \
                ${datadir}/doc/cups/*html \
                ${datadir}/doc/cups/*.css \
                ${datadir}/icons/ \
                "

CONFFILES_${PN} += "${sysconfdir}/cups/cupsd.conf"

LEAD_SONAME = "libcupsdriver.so"

fakeroot do_install () {
    oe_runmake "DSTROOT=${D}" install
    # This directory gets installed with perms 511, which makes packaging fail
    chmod 0711 "${D}/${localstatedir}/run/cups/certs"

    install -d ${D}/${libdir}/cups/filter
    install -m 755 ${WORKDIR}/textonly ${D}/${libdir}/cups/filter

    install -d ${D}/${datadir}/cups/mime
    install -m 644 ${WORKDIR}/text.convs ${D}/${datadir}/cups/mime

    install -d ${D}/${datadir}/ppd/cups-included
    install -m 644 ${WORKDIR}/textonly.ppd ${D}/${datadir}/ppd/cups-included
}

python do_package_append() {
	# Change permissions back the way they were, they probably had a reason...
	workdir = bb.data.getVar('WORKDIR', d, 1)
	os.system('chmod 0511 %s/install/cups/var/run/cups/certs' % workdir)
}
