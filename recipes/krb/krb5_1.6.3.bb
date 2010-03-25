DESCRIPTION = "A network authentication protocol"
HOMEPAGE = "http://web.mit.edu/Kerberos/"
SECTION = "console/network"
PR = "r6"
LICENSE = "MIT"
DEPENDS = "perl-native ncurses util-linux-ng e2fsprogs-native"

inherit autotools binconfig

SRC_URI = "http://web.mit.edu/kerberos/dist/krb5/1.6/krb5-1.6.3-signed.tar \
           file://fix-uclibc-ruserpass-collision.patch \
           file://copyperms.patch"

S = "${WORKDIR}/${PN}-${PV}/src/"

# Will clean this up...
EXTRA_OECONF += " --without-tcl krb5_cv_attr_constructor_destructor=yes ac_cv_func_regcomp=yes \
                  ac_cv_printf_positional=yes ac_cv_file__etc_environment=yes \
                  ac_cv_file__etc_TIMEZONE=no --with-system-et"
CFLAGS_append += "-DDESTRUCTOR_ATTR_WORKS=1 -I${STAGING_INCDIR}/et"
LDFLAGS_append += "-lpthread"

FILES_${PN}-doc += /usr/share/examples

krb5_do_unpack() {
	tar xzf ${WORKDIR}/krb5-1.6.3.tar.gz -C ${WORKDIR}/
	patch -d ${S} -p1 < ${WORKDIR}/fix-uclibc-ruserpass-collision.patch
	patch -d ${S} -p1 < ${WORKDIR}/copyperms.patch
}

python do_unpack() {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('krb5_do_unpack', d)
}

do_configure() {
	oe_runconf
}

do_install_append () {
	mv ${D}${bindir}/ftp ${D}${bindir}/ftp.${PN}
	mv ${D}${sbindir}/ftpd ${D}${sbindir}/ftpd.${PN}
	mv ${D}${bindir}/telnet ${D}${bindir}/telnet.${PN}
	mv ${D}${sbindir}/telnetd ${D}${sbindir}/telnetd.${PN}
}

pkg_postinst_${PN} () {
#!/bin/sh
	update-alternatives --install ${bindir}/ftp ftp ftp.${PN} 100
	update-alternatives --install ${sbindir}/ftpd ftpd ftpd.${PN} 100
	update-alternatives --install ${bindir}/telnet telnet telnet.${PN} 100
	update-alternatives --install ${sbindir}/telnetd telnetd telnetd.${PN} 100
}

pkg_prerm_${PN} () {
#!/bin/sh
	update-alternatives --remove ftp ftp.${PN} 100
	update-alternatives --remove ftpd ftpd.${PN} 100
	update-alternatives --remove telnet telnet.${PN} 100
	update-alternatives --remove telnetd telnetd.${PN} 100
}

do_stage() {
	oe_libinstall -so -C util/support libkrb5support ${STAGING_LIBDIR}
	oe_libinstall -so -C util/et libcom_err ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/crypto libk5crypto ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/krb5 libkrb5 ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/des425 libdes425 ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/krb4 libkrb4 ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/gssapi libgssapi_krb5 ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/rpc libgssrpc ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/kdb libkdb5 ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/kadm5/clnt libkadm5clnt ${STAGING_LIBDIR}
	oe_libinstall -so -C lib/kadm5/srv libkadm5srv ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/krb5
	for X in krb5.h locate_plugin.h
	do
		install -m 0644 ${S}/include/krb5/$X ${STAGING_INCDIR}/krb5/$X
	done

	install -d ${STAGING_INCDIR}/gssapi
	for X in gssapi_generic.h gssapi.h gssapi_krb5.h
	do
		install -m 0644 ${S}/include/gssapi/$X ${STAGING_INCDIR}/gssapi/$X
	done
	install -m 0644 ${S}/lib/gssapi/mechglue/mechglue.h ${STAGING_INCDIR}/gssapi/mechglue.h

	install -d ${STAGING_INCDIR}/kerberosIV
	for X in krb.h des.h mit-copyright.h krb_err.h kadm_err.h
	do
		install -m 0644 ${S}/include/kerberosIV/$X ${STAGING_INCDIR}/kerberosIV/$X
	done

	install -d ${STAGING_INCDIR}/gssrpc
	for X in auth.h auth_gss.h auth_gssapi.h auth_unix.h clnt.h netdb.h pmap_clnt.h pmap_prot.h pmap_rmt.h rename.h rpc.h rpc_msg.h svc.h svc_auth.h xdr.h types.h
	do
		install -m 0644 ${S}/include/gssrpc/$X ${STAGING_INCDIR}/gssrpc/$X
	done

	# com_err.h needs to be added here if you choose to use this builtin
	for X in krb5.h profile.h gssapi.h
	do
		install -m 0644 ${S}/include/$X ${STAGING_INCDIR}/$X
	done
}
