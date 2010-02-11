DESCRIPTION = "Perl is a popular scripting language."
HOMEPAGE = "http://www.perl.org/"
LICENSE = "Artistic|GPL"
PR = "r4"

SECTION = "libs"
inherit native

DEPENDS = "virtual/db-native gdbm-native"

SRC_URI = "http://ftp.funet.fi/pub/CPAN/src/5.0/perl-${PV}.tar.gz"
S = "${WORKDIR}/perl-${PV}"

do_configure () {
    ./Configure					\
    -Dcc="${CC}"				\
    -Dcflags="${CFLAGS}"			\
    -Dldflags="${LDFLAGS}"		\
    -Dusethreads				\
    -Duselargefiles				\
    -Dprefix=${prefix}				\
    -Dvendorprefix=${prefix}			\
    -Dsiteprefix=${prefix}/local		\
    -Dman1ext=1					\
    -Dman3ext=3perl				\
    -Uafs					\
    -Ud_csh					\
    -Uusesfio					\
    -Uusenm -des
    sed 's!${STAGING_DIR}/bin!${STAGING_BINDIR}!;
         s!${STAGING_DIR}/lib!${STAGING_LIBDIR}!' < config.sh > config.sh.new
    mv config.sh.new config.sh
}
