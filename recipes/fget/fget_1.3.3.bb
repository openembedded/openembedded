LICENSE = "BSD"
DESCRIPTION = "fget is a commandline tool for mirroring \
remote files via FTP. It was designed as an analog to the \
GNU wget utility. The fget package includes an FTP client \
library, so that others can make use of FTP from within \
their own C programs."
SECTION = "libs"
PRIORITY = "optional"

SRC_URI = "ftp://ftp.feep.net/pub/software/fget/fget-${PV}.tar.gz"

inherit autotools

do_configure() {
	oe_runconf
}

do_stage() {
	oe_libinstall -a -C lib libfget ${STAGING_LIBDIR}
	install -m 0755 lib/libfget.h ${STAGING_INCDIR}/
}


SRC_URI[md5sum] = "a556eef04aeb574ac8ab0dd8c868fcab"
SRC_URI[sha256sum] = "ceaa67f19a1c5462f5e739fcd3b53dd42b0173d9deee579c55e5088801559e43"
