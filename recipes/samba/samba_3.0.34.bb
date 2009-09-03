require samba.inc
require samba-basic.inc

SRC_URI += "file://configure.patch;patch=1 \
            "
SRC_URI_append_linux-uclibc        = "file://uclibc-strlcpy-strlcat.patch;patch=1"
SRC_URI_append_linux-uclibceabi = "file://uclibc-strlcpy-strlcat.patch;patch=1"

PR = "r5"

PACKAGES =+ " smbfs smbfs-doc"

FILES_smbfs = "${bindir}/smbmount ${bindir}/smbumount ${bindir}/smbmnt ${base_sbindir}/mount.smbfs ${base_sbindir}/mount.smb"
RCONFLICTS_smbfs-doc = "smbfs-ads-doc"
FILES_smbfs-doc = "${mandir}/man8/smbmount.8 ${mandir}/man8/smbumount.8 ${mandir}/man8/smbmnt.8"

EXTRA_OECONF += "\
	SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
	--with-smbmount \
	"

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
