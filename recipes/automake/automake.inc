DESCRIPTION = "A tool for automatically generating Makefiles."
LICENSE = "GPL"
HOMEPAGE = "http://www.gnu.org/software/automake/"
SECTION = "devel"
DEPENDS_virtclass-native = "autoconf-native perl-native"
RDEPENDS_automake-native = "autoconf-native perl-native"
RDEPENDS_automake += "\
    autoconf \
    perl \
    perl-module-bytes \
    perl-module-constant \
    perl-module-cwd \
    perl-module-data-dumper \
    perl-module-dynaloader \
    perl-module-errno \
    perl-module-exporter-heavy \
    perl-module-file-basename \
    perl-module-file-compare \
    perl-module-file-copy \
    perl-module-file-glob \
    perl-module-file-path \
    perl-module-file-spec-unix \
    perl-module-file-stat \
    perl-module-getopt-long \
    perl-module-io \
    perl-module-io-file \
    perl-module-posix \
    perl-module-strict \
    perl-module-text-parsewords \
    perl-module-vars "
SRC_URI = "${GNU_MIRROR}/automake/automake-${PV}.tar.bz2;name=automake"
INC_PR = "r5"
AUTOMAKE_API = "${@".".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"

inherit autotools

FILES_${PN} += "${datadir}/automake* ${datadir}/aclocal*"

do_configure_append() {
}

do_install_append () {
	autotools_do_install
	# replace paths to STAGING_BINDIR_NATIVE/perl with ${bindir}/perl
	sed -i -e "1s:#!.*:#! /usr/bin/env perl:" ${D}${bindir}/*
	ln -sf aclocal-${AUTOMAKE_API} ${D}${bindir}/aclocal
	ln -sf automake-${AUTOMAKE_API} ${D}${bindir}/automake
	install -d ${D}${datadir}/aclocal
}

do_install_append_pn-automake(){
	sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g ${D}${bindir}/*
}

BBCLASSEXTEND = "native"
