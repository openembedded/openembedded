# PAM authentication library for Linux - Linux-PAM
#
# NOTE: this is a library with plug-in modules, at present all
# the modules are built and installed into the main libpam
# ipkg.  This causes lots of problems (e.g. it is not possible
# to build on uClibC) so *do not* rely on this behaviour -
# assume the modules will be moved to individual ipks (like
# the kernel modules.)
#
DESCRIPTION = "\
PAM authentication library for Linux.  \
Linux-PAM (Pluggable Authentication Modules for Linux) is a \
library that enables the local system administrator to choose \
how individual applications authenticate users. For an \
overview of the Linux-PAM library see the Linux-PAM System \
Administrators' Guide."
HOMEPAGE = "http://www.kernel.org/pub/linux/libs/pam"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL-2"

# The project is actually called Linux-PAM but that gives
# a bad OE package name because of the upper case characters
pn = "Linux-PAM"
p = "${pn}-${PV}"
S = "${WORKDIR}/${p}"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/libs/pam/pre/library/${p}.tar.bz2"

# the patches are necessary to get the autoreconf and cross build
# to work correctly
SRC_URI += " file://libpam-config.patch;patch=1"
# The Makefile uses 'FAKEROOT' not DESTDIR.
SRC_URI += " file://libpam-make.patch;patch=1"

inherit autotools

# EXTRA_OECONF += " --enable-static-libpam"

LEAD_SONAME = "libpam.so.*"

# This is crude - the modules maybe should each have independent ipks
FILES_${PN} += "/usr/lib/security/pam_*.so /usr/lib/security/pam_filter/*"

do_stage() {
	autotools_stage_includes
	for lib in libpam libpamc libpam_misc
	do
		oe_libinstall -so -C "$lib" "$lib" ${STAGING_LIBDIR}
	done
}

# An attempt to build on uclibc will fail, causing annoyance,
# so force the package to be skipped here (this will cause a
# 'nothing provides' error)
#NOTE: this can be fixed, but it means hacking the modules so
# that those which use YP don't get built on uClibC, this looks
# like a big patch...
python () {
	os = bb.data.getVar("TARGET_OS", d, 1)
	if os == "linux-uclibc":
		raise bb.parse.SkipPackage("Some PAM modules require rpcsvc/yp.h, uClibC does not provide this")
}
