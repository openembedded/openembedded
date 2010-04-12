require kexec-tools.inc
export LDFLAGS = "-L${STAGING_LIBDIR}"
EXTRA_OECONF = " --with-zlib=yes"

PR = "r5"

SRC_URI[md5sum] = "b4f7ffcc294d41a6a4c40d6e44b7734d"
SRC_URI[sha256sum] = "280b34fefa12c3d7a3e432c3730fe5d0d56e8d169c28b695cce9ba6d8dbe6e38"
