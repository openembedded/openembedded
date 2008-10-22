# This package builds the 'upslug' binary upload/flash tool
# for the NSLU2.  It is not useful for anything else.
PR = "r1"
DESCRIPTION = "NSLU2 binary upload tool"
HOMEPAGE = "http://www.nslu2-linux.org/wiki/Main/UpSlug"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"
COMPATIBLE_MACHINE = "nslu2"

# Use releases in preference
DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@nslu.cvs.sourceforge.net/cvsroot/nslu;method=pserver;module=upslug"

inherit native

S = "${WORKDIR}/upslug"

# Dumb compile script
do_compile() {
	oe_runmake "CC=${CC}" "CFLAGS=${CFLAGS}"
}

do_stage() {
	oe_runmake "DESTDIR=${STAGING_BINDIR}" install
}
