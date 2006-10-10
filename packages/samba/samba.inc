SECTION = "console/network"
DEPENDS = readline
LICENSE = "GPL"

PACKAGES =+ "libsmbclient libsmbclient-dev cifs cifs-doc"
FILES_cifs = "${bindir}/mount.cifs"
FILES_cifs-doc = "${docdir}/mount.cifs.8"
FILES_libsmbclient = "${libdir}/libsmbclient.so.*"
FILES_libsmbclient-dev = "${libdir}/libsmbclient.so ${includedir}"

inherit autotools

EXTRA_OECONF='--disable-cups --with-readline=${STAGING_LIBDIR}/.. \
	      --without-ads --without-automount --with-smbmount'
do_configure_prepend () {
	./script/mkversion.sh
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}

do_compile () {
	oe_runmake proto_exists
	base_do_compile
	${CC} client/mount.cifs.c -o mount.cifs
}

do_install_append() {
	mv ${D}${libdir}/libsmbclient.so ${D}${libdir}/libsmbclient.so.0
	ln -sf libsmbclient.so.0 ${D}${libdir}/libsmbclient.so
	rm -f ${D}${bindir}/*.old
	rm -f ${D}${sbindir}/*.old
	install -c -m 755 mount.cifs  ${D}${bindir}/mount.cifs
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
