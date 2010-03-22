require gnupg.inc

DEPENDS += "readline"
EXTRA_OECONF += "--with-readline=${STAGING_LIBDIR}/.. ac_cv_sys_symbol_underscore=yes"
#   --without-readline      do not support fancy command line editing

SRC_URI += "file://long-long-thumb.patch;patch=1"
SRC_URI[src.md5sum] = "dcf7ed712997888d616e029637bfc303"
SRC_URI[src.sha256sum] = "a2907f4432d67894e425e48ae85785dd60ecb01658c9682bcd96f5e91043bb38"

S = "${WORKDIR}/gnupg-${PV}"

PR = "r2"
