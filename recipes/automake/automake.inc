DESCRIPTION = "A tool for automatically generating Makefiles."
LICENSE = "GPL"
HOMEPAGE = "http://www.gnu.org/software/automake/"
SECTION = "devel"
DEPENDS_virtclass-native = "autoconf-native"
RDEPENDS_automake-native = "autoconf-native perl-native-runtime"
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
SRC_URI = "${GNU_MIRROR}/automake/automake-${PV}.tar.bz2"
INC_PR = "r3"
AUTOMAKE_API = "${@".".join(bb.data.getVar("PV",d,1).split(".")[0:2])}"

inherit autotools

FILES_${PN} += "${datadir}/automake* ${datadir}/aclocal*"

do_configure_prepend () {
	if ${@['true', 'false'][bb.data.inherits_class('native', d)]}
	then
		export ac_cv_path_PERL="${ac_cv_path_PERL=${bindir}/perl}"
	fi
}

do_install_append () {
	autotools_do_install
	ln -sf aclocal-${AUTOMAKE_API} ${D}${bindir}/aclocal
	ln -sf automake-${AUTOMAKE_API} ${D}${bindir}/automake
	install -d ${D}${datadir}/aclocal
}

BBCLASSEXTEND = "native"
