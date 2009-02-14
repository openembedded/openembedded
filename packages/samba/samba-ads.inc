# openldap and kerberos are for active directory support
# netatalk is needed to support a vfs module
DEPENDS += " openldap krb5 netatalk"

EXTRA_OECONF += "\
        SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
        samba_cv_CC_NEGATIVE_ENUM_VALUES=yes \
        linux_getgrouplist_ok=no \
        samba_cv_HAVE_BROKEN_GETGROUPS=no \
        samba_cv_HAVE_FTRUNCATE_EXTEND=yes \
        ac_cv_path_KRB5CONFIG=${STAGING_BINDIR_CROSS}/krb5-config \
        samba_cv_have_setresuid=yes \
        samba_cv_have_setresgid=yes \
        samba_cv_HAVE_WRFILE_KEYTAB=yes \
        smb_krb5_cv_enctype_to_string_takes_krb5_context_arg=yes \
        smb_krb5_cv_enctype_to_string_takes_size_t_arg=yes \
        --with-krb5=${STAGING_LIBDIR} \
        --with-ads \
        "

PACKAGES =+ "libsmbclient-ads libsmbclient-ads-dev cifs-ads cifs-ads-doc swat-ads"

RCONFLICTS_${PN} = "samba"
RCONFLICTS_libsmbclient-ads = "libsmbclient"
RCONFLICTS_libsmbclient-ads-dev = "libsmbclient-dev"
RCONFLICTS_cifs-ads = "cifs"
RCONFLICTS_cifs-ads-doc = "cifs-doc"
RCONFLICTS_swat-ads = "swat"

FILES_cifs-ads = "${base_sbindir}/mount.cifs ${base_sbindir}/umount.cifs"
FILES_cifs-ads-doc = "${mandir}/man8/mount.cifs.8 ${mandir}/man8/umount.cifs.8"
FILES_libsmbclient-ads = "${libdir}/libsmbclient.so.*"
FILES_libsmbclient-ads-dev = "${libdir}/libsmbclient.so ${includedir}"
FILES_swat-ads = "${sbindir}/swat ${datadir}/swat ${libdir}/*.msg"

do_configure() {
        oe_runconf
}
