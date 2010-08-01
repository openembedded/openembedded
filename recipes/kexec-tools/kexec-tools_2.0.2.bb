require kexec-tools_${PV}.inc

PR = "r0"

EXTRA_OECONF = " --with-zlib=yes"
export LDFLAGS = "-L${STAGING_LIBDIR}"
