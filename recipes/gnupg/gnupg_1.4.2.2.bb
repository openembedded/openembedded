require gnupg.inc

DEPENDS += "readline"
EXTRA_OECONF += "--with-readline=${STAGING_LIBDIR}/.."
#   --without-readline      do not support fancy command line editing

SRC_URI += "file://15_free_caps.patch;patch=1 \
	    file://16_min_privileges.patch;patch=1 \
	    file://22_zero_length_mpi_fix.patch;patch=1 \
            file://30_nm_always_check.patch;patch=1 \
            file://long-long-thumb.patch;patch=1 \
            file://dont_use_mips_h_constraint.patch;patch=1 \
	   "

S = "${WORKDIR}/gnupg-${PV}"

PR = "r4"
