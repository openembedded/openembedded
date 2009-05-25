require samba.inc
require samba-basic.inc
LICENSE = "GPLv3"

SRC_URI += "file://configure-3.2.8.patch;patch=1 \
            file://config-h.patch;patch=1 \
            file://mtab.patch;patch=1 \
	        "

PR = "r1"

EXTRA_OECONF += "\
	SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
	samba_cv_CC_NEGATIVE_ENUM_VALUES=yes \
	linux_getgrouplist_ok=no \
	samba_cv_HAVE_BROKEN_GETGROUPS=no \
	samba_cv_HAVE_FTRUNCATE_EXTEND=yes \
	samba_cv_have_setresuid=yes \
	samba_cv_have_setresgid=yes \
	samba_cv_HAVE_WRFILE_KEYTAB=yes \
	"

do_configure() {
	oe_runconf
}
