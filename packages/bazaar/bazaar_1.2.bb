# bazaar OE build file
# Copyright (C) 2005 Chris Larson <kergoth@handhelds.org>
# Released under the MIT license (see the COPYING file in this tree)
#
# NOTE:
#   * Does not have an LDFLAGS variable on its link lines, only the "libs"
#     variable, which makes it troublesome to add -L's to the link.  For now,
#     we cheat and pass it in CFLAGS.

DEPENDS += "neon"
DESCRIPTION = "bazaar is an implementation of GNU Arch in C, based on tla."
HOMEPAGE = "http://bazaar.canonical.com/"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PRIORITY = "optional"
SECTION = "devel"
PR = "r2"
RDEPENDS_${PN} += "patch"
RSUGGESTS_${PN} += "gnupg"

SRC_URI = "http://bazaar.canonical.com/releases/src/bazaar_${PV}.tar.gz \
	   file://no_archive_format_guess_msg.patch;patch=1 \
	   file://import_dirarg.patch;patch=1"

S = "${WORKDIR}/thelove@canonical.com---dists--bazaar--1.2"
B = "${WORKDIR}/build-${HOST_SYS}"

CFLAGS += "-I${B} -I${S}/src -I${S}/src/baz"
EXTRA_OEMAKE = "'CC=${CC}' \
		'CFLAGS=${CFLAGS} ${LDFLAGS}' \
		\
		'test-scripts=' \
		'test-progs=' \
		'prefix=${D}${prefix}' \
		'program-install-dir=${D}${bindir}' \
		'cgi-install-dir=${D}${libdir}/cgi' \
		'library-install-dir=${D}${libdir}' \
		'include-install-dir=${D}${includedir}/$(thispath)' \
		'etc-install-dir=${D}${sysconfdir}' \
		'libexec-install-dir=${D}${libexecdir}' \
		'info-install-dir=${D}${infodir}' \
		'man-install-dir=${D}${mandir}' \
		'scm-install-dir=${D}${datadir}/scheme' \
		'doc-install-dir=${D}${docdir}/$(thispath)' \
		'data-install-dir=${D}${datadir}/$(thispath)' \
		'locale-install-dir=${D}${datadir}/locale'"
PARALLEL_MAKE = ""


do_configure () {
	${S}/src/configure ${CONFARGS}

}

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install-all
	sed -e 's,^#!.*$$,#!/usr/bin/gawk -f,' ${S}/src/baz/=gpg-check.awk > \
		${D}${bindir}/bazaar-gpg-check
}
