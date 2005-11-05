# This package builds the 'upslug' binary upload/flash tool
# for the NSLU2.  It is not useful for anything else.
PR = "r0"
DESCRIPTION = "NSLU2 binary upload tool"
HOMEPAGE = "http://www.nslu2-linux.org/wiki/Main/UpSlug"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL-2"

# Use releases in preference
DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/nslu;method=pserver;module=upslug"

inherit native

S = "${WORKDIR}/upslug"

# Dumb compile script
do_compile() {
	oe_runmake "CC=${CC}" "CFLAGS=${CFLAGS}"
}

do_stage() {
	oe_runmake "DESTDIR=${STAGING_BINDIR}" install
}

python () {
	# Don't build upslug unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("upslug only builds for the Linksys NSLU2")
}
