SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "readline virtual/libiconv"

SRC_URI = "http://samba.org/samba/ftp/stable/samba-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://config-lfs.patch;patch=1 \
           file://quota.patch;patch=1;pnum=0 \
           file://smb.conf \
           file://init"

S = "${WORKDIR}/samba-${PV}/source"

inherit autotools update-rc.d

# The file system settings --foodir=dirfoo and overridden unconditionally
# in the samba config by --with-foodir=dirfoo - even if the --with is not
# specified!  Fix that here.  Set the privatedir to /etc/samba/private.
EXTRA_OECONF='--disable-cups \
              --with-readline=${STAGING_LIBDIR}/.. \
              --with-libiconv=${STAGING_LIBDIR}/.. \
              --without-automount \
              --with-smbmount \
              --with-configdir=${sysconfdir}/samba \
              --with-privatedir=${sysconfdir}/samba/private \
              --with-lockdir=${localstatedir}/lock \
              --with-piddir=${localstatedir}/run \
              --with-logfilebase=${localstatedir}/log \
              --with-libdir=${libdir} \
              --with-mandir=${mandir} \
              --with-swatdir=${datadir}/swat \
              samba_cv_struct_timespec=yes'

INITSCRIPT_NAME = "samba"
# No dependencies, goes in at level 20 (NOTE: take care with the
# level, later levels put the shutdown later too - see the links
# in rc6.d, the shutdown must precede network shutdown).
INITSCRIPT_PARAMS = "defaults"
CONFFILES_${PN} = "${sysconfdir}/samba/smb.conf"

PACKAGES =+ "libsmbclient libsmbclient-dev cifs cifs-doc smbfs smbfs-doc swat"
FILES_cifs = "${base_sbindir}/mount.cifs ${base_sbindir}/umount.cifs"
FILES_cifs-doc = "${mandir}/man8/mount.cifs.8 ${mandir}/man8/umount.cifs.8"
FILES_libsmbclient = "${libdir}/libsmbclient.so.*"
FILES_libsmbclient-dev = "${libdir}/libsmbclient.so ${includedir}"
FILES_smbfs = "${bindir}/smbmount ${bindir}/smbumount ${bindir}/smbmnt ${base_sbindir}/mount.smbfs ${base_sbindir}/mount.smb"
FILES_smbfs-doc = "${mandir}/man8/smbmount.8 ${mandir}/man8/smbumount.8 ${mandir}/man8/smbmnt.8"
FILES_swat       = "${sbindir}/swat ${datadir}/swat ${libdir}/*.msg"
FILES_${PN}     += "${libdir}/vfs/*.so ${libdir}/charset/*.so ${libdir}/*.dat \
                    ${libdir}/auth/*.so ${libdir}/security/*.so"
FILES_${PN}-dbg += "${libdir}/vfs/.debug/*.so ${libdir}/charset/.debug/*.so \
                    ${libdir}/auth/.debug/*.so ${libdir}/security/.debug/*.so"

do_configure_prepend () {
	./script/mkversion.sh
	if [ ! -e acinclude.m4 ]; then
		touch aclocal.m4	
		cat aclocal.m4 > acinclude.m4
	fi
}

do_compile () {
	oe_runmake proto_exists
	base_do_compile
}

do_install_append() {
	mv ${D}${libdir}/libsmbclient.so ${D}${libdir}/libsmbclient.so.0 || true
	ln -sf libsmbclient.so.0 ${D}${libdir}/libsmbclient.so
	mkdir -p ${D}${base_sbindir}
	rm -f ${D}${sbindir}/mount.smbfs ${D}${base_sbindir}/mount.smbfs
	ln -sf ${bindir}/smbmount ${D}${base_sbindir}/mount.smb
	ln -sf ${bindir}/smbmount ${D}${base_sbindir}/mount.smbfs
	rm -f ${D}${bindir}/*.old
	rm -f ${D}${sbindir}/*.old
	[ -f ${D}${sbindir}/mount.cifs ] && mv ${D}${sbindir}/mount.cifs ${D}${base_sbindir}/
	[ -f ${D}${sbindir}/umount.cifs ] && mv ${D}${sbindir}/umount.cifs ${D}${base_sbindir}/

	install -d "${D}/var/log/samba"
	install -d "${D}${sysconfdir}/init.d"
	install -c -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/samba
	install -d "${D}${sysconfdir}/samba"
	install -c -m 644 ${WORKDIR}/smb.conf ${D}${sysconfdir}/samba/smb.conf
	install -d ${D}/var/spool/samba
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
	oe_libinstall -C bin -a -so libtdb ${STAGING_LIBDIR}
	oe_libinstall -C bin -a -so libtalloc ${STAGING_LIBDIR}
	oe_libinstall -C bin -so libwbclient ${STAGING_LIBDIR}
}
