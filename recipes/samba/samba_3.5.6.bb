require samba.inc
require samba-basic.inc
LICENSE = "GPLv3"
S = "${WORKDIR}/samba-${PV}/source3"

# 3.3.0 and newer will upgrade your tdb database to a
# new version that you can not downgrade to use with older
# releases. More testing will happen before this is removed
# should there be further issues. Appears to work though :)
DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://config-h.patch \
            file://tdbheaderfix.patch;apply=no"

PR = "r0"

EXTRA_OECONF += "\
	SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
	samba_cv_CC_NEGATIVE_ENUM_VALUES=yes \
	linux_getgrouplist_ok=no \
	samba_cv_HAVE_BROKEN_GETGROUPS=no \
	samba_cv_HAVE_FTRUNCATE_EXTEND=yes \
	samba_cv_have_setresuid=yes \
	samba_cv_have_setresgid=yes \
	samba_cv_HAVE_WRFILE_KEYTAB=yes \
	samba_cv_linux_getgrouplist_ok=yes \
	"

do_configure() {
	# Patches we must apply by hand due to layout.
	cd ..
	patch -p1 -i ${WORKDIR}/tdbheaderfix.patch
	cd source3

	oe_runconf
}

do_compile () {
	base_do_compile
}

SRC_URI[md5sum] = "bf6c09ea497a166df8bd672db1d8da8f"
SRC_URI[sha256sum] = "466410868375d19a286ac3fc5d9f3c267ce359189f8e0d76e72ec10bd54247da"
