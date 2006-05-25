# Clearsilver
SECTION = "net"
DESCRIPTION = "Clearsilver is a fast, powerful, and language-neutral HTML template system"
LICENSE = "Neotonic ClearSilver License"
DEPENDS = "python"
MAINTAINER = "Cliff Brake <cliff.brake@gmail.com>"
PR = "r0"

SRC_URI = "http://www.clearsilver.net/downloads/${P}.tar.gz \
           file://crosscompile.patch;patch=1"

EXTRA_OECONF = "--disable-apache --disable-perl --disable-ruby --disable-java --disable-csharp --enable-gettext --with-python=${STAGING_BINDIR}/python"

inherit autotools

FILES_${PN} += "/usr/lib/python*"

do_compile() {
	BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} oe_runmake
}

do_configure() {
	gnu-configize
	oe_runconf
}


