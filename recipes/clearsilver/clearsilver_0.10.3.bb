# Clearsilver
SECTION = "net"
DESCRIPTION = "Clearsilver is a fast, powerful, and language-neutral HTML template system"
LICENSE = "Neotonic ClearSilver License"
DEPENDS = "python"
PR = "r2"

SRC_URI = "http://www.clearsilver.net/downloads/${P}.tar.gz \
           file://crosscompile.patch;patch=1"

EXTRA_OECONF = "--disable-apache --disable-perl --disable-ruby --disable-java --disable-csharp --enable-gettext --with-python=${STAGING_BINDIR_NATIVE}/python"

inherit autotools distutils-common-base

export PYTHON_DIR

do_compile() {
	BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} oe_runmake
}

do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
        autotools_stage_includes
        for i in libs/libneo_cgi.a libs/libneo_cs.a libs/libneo_utl.a; do
            install -m 644 $i ${STAGING_LIBDIR}
        done
}

SRC_URI[md5sum] = "ff4104b0e58bca1b61d528edbd902769"
SRC_URI[sha256sum] = "71d8c6459a4be1912dbc445e2e9d46303be6623cea51563c21abe39c8b5b0bd2"
