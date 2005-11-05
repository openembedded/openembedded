include gnupg.inc

DEPENDS += "readline"
EXTRA_OECONF += "--with-readline=${STAGING_LIBDIR}/.."
#   --without-readline      do not support fancy command line editing

SRC_URI += "file://15_free_caps.patch;patch=1 \
	    file://16_min_privileges.patch;patch=1 \
	    file://18_ca_po_update.patch;patch=1 \
	    file://21_strgutil_update.patch;patch=1"
S = "${WORKDIR}/gnupg-${PV}"
