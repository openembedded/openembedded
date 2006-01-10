# FIXME: Update to work with some other MD5 implementation.
# It's silly to pull in OpenSSL just for that.
DEPENDS = "openssl"
DESCRIPTION = "BSD-licensed equivalent of the popular versioning system CVS."
LICENSE = "BSD"
PRIORITY = "optional"
SECTION = "console/network"
PV = "0.0+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "cvs://anoncvs@anoncvs.ca.openbsd.org/cvs;method=ext;module=src/usr.bin/cvs \
	   file://linux.patch;patch=1"
S = "${WORKDIR}/cvs"

inherit autotools

do_clean_tree () {
	rm -rf ${S}/cvs ${S}/cvsd
}
addtask clean_tree after do_patch before do_configure
