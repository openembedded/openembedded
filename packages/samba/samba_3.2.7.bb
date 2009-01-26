require samba.inc

PR = "r1"
DEPENDS += " openldap krb5"
SRC_URI += "file://config-h.patch;patch=1 \
            file://mtab.patch;patch=1 \
	        "

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

do_configure() {
	oe_runconf
}
