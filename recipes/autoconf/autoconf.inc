DESCRIPTION = "A package of M4 macros to produce scripts to \
automatically configure sourcecode."
LICENSE = "GPLv3+-with-Autoconf-Configure-Script-Exception-v3.0"
HOMEPAGE = "http://www.gnu.org/software/autoconf/"
SECTION = "devel"
DEPENDS += "m4-native perl-native"
RDEPENDS_${PN} = "m4 perl gnu-config"
DEPENDS_virtclass-native = "m4-native gnu-config-native perl-native"
RDEPENDS_${PN}_virtclass-native = "m4-native gnu-config-native perl-native"

INC_PR = "r14"

SRC_URI = "${GNU_MIRROR}/autoconf/autoconf-${PV}.tar.bz2;name=autoconf \
	   file://program_prefix.patch"

inherit autotools

# Excluded: tests man doc
SUBDIRS = "bin . lib"

do_configure_prepend () {
	if ${@['true', 'false'][bb.data.inherits_class('native', d)]}
	then
		export ac_cv_path_PERL="${ac_cv_path_PERL=${bindir}/perl}"
		export ac_cv_path_M4="${ac_cv_path_M4=${bindir}/m4}"
		export ac_cv_prog_gnu_m4="${ac_cv_prog_gnu_m4=yes}"
	fi

	sed -i -e's,^SUBDIRS = .*,SUBDIRS = ${SUBDIRS},' ${S}/Makefile.am
}

do_configure_append() {
	# replace paths to STAGING_BINDIR_NATIVE/perl with ${bindir}/perl
	sed -i -e "1s:#!.*:#! /usr/bin/env perl:" ${S}/bin/*.in
}

do_install_append_pn-autoconf(){
	sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g ${D}${bindir}/*
}

PARALLEL_MAKE = ""
BBCLASSEXTEND = "native"
