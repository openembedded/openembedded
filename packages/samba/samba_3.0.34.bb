require samba.inc
require samba-basic.inc

SRC_URI += "file://configure.patch;patch=1 \
            "
SRC_URI_append_linux-uclibc        = "file://uclibc-strlcpy-strlcat.patch;patch=1"
SRC_URI_append_linux-uclibcgnueabi = "file://uclibc-strlcpy-strlcat.patch;patch=1"

PR = "r4"

PACKAGES =+ "smbfs-doc"

RCONFLICTS_smbfs-doc = "smbfs-ads-doc"

FILES_smbfs-doc = "${mandir}/man8/smbmount.8 ${mandir}/man8/smbumount.8 ${mandir}/man8/smbmnt.8"

EXTRA_OECONF += "\
	SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
	"

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
