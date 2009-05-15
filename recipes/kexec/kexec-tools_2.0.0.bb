require kexec-tools2.inc
export LDFLAGS = "-L${STAGING_LIBDIR}"
EXTRA_OECONF = " --with-zlib=yes"

PR = "r0"

DEFAULT_PREFERENCE = "-1"
