require samba.inc
require samba-basic.inc
LICENSE = "GPLv3"

SRC_URI += "file://configure-3.2.8.patch \
            file://config-h.patch \
            file://mtab.patch \
	        "
SRC_URI[md5sum] = "5a3bcc4927c9643b9f42970d0815b18f"
SRC_URI[sha256sum] = "84281fd1faeffee8558e49dff865dd382abbf78bc1be00f8cb5aa70aeea67d46"

PR = "r4"

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

EXTRA_OECONF_append_libc-uclibc = " --disable-pie"
# for arm we always use ARM instruction set
# gcc 4.5 ICE's in thumb mode
# see http://gcc.gnu.org/bugzilla/show_bug.cgi?id=46934

ARM_INSTRUCTION_SET = "arm"
do_configure() {
	oe_runconf
}
