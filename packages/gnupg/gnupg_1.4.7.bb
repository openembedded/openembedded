require gnupg.inc

DEPENDS += "readline"
EXTRA_OECONF += "--with-readline=${STAGING_LIBDIR}/.."
#   --without-readline      do not support fancy command line editing

SRC_URI += "file://15_free_caps.dpatch;patch=1 \
	    file://16_min_privileges.dpatch;patch=1 \
            file://24_gpgv_manpage_cleanup.dpatch;patch=1 \
            file://25_de.po_fixes.dpatch;patch=1"

S = "${WORKDIR}/gnupg-${PV}"
