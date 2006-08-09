SECTION = "console/network"
DEPENDS = readline
LICENSE = "GPL"

PACKAGES =+ "libsmbclient libsmbclient-dev cifs cifs-doc sambaserver sambamount"
FILES_cifs = "${bindir}/mount.cifs"
FILES_cifs-doc = "${docdir}/mount.cifs.8"
FILES_libsmbclient = "${libdir}/libsmbclient.so.*"
FILES_libsmbclient-dev = "${libdir}/libsmbclient.so ${includedir}"
FILES_sambaserver = "${sbindir}/smbd ${sbindir}/nmbd ${libdir}/charset/*.so ${libdir}/*.dat"
FILES_sambamount = "${bindir}/smbmount ${bindir}/smbmnt"

FILES_sambaserver_append_opendreambox = " /etc/samba/smb.conf /etc/samba/private \
	/etc/network/if-up.d/01samba-start /etc/network/if-down.d/01samba-kill"

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

do_install_prepend_opendreambox() {
	install -c -m 644 ${FILESDIR}/smb.conf ../examples/smb.conf.default
}

do_install_append_opendreambox() {
	install -d ${D}/etc/samba
	install -d ${D}/etc/samba/private
	install -d ${D}/etc/network/if-down.d
	install -m 0755 ${FILESDIR}/01samba-kill ${D}/etc/network/if-down.d
	install -d ${D}/etc/network/if-up.d
	install -m 0755 ${FILESDIR}/01samba-start ${D}/etc/network/if-up.d
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
