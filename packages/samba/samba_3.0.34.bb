require samba.inc

PR = "r2"

SRC_URI_append_linux-uclibc = " \
        file://uclibc-strlcpy-strlcat.patch;patch=1"
SRC_URI_append_linux-uclibcgnueabi = " \
        file://uclibc-strlcpy-strlcat.patch;patch=1"

EXTRA_OECONF += "\
	--without-ads \
	SMB_BUILD_CC_NEGATIVE_ENUM_VALUES=yes \
	"

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
