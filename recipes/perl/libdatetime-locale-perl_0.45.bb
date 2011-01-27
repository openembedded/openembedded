DESCRIPTION = "DateTime::Locale - Localization support for DateTime.pm"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
HOMEPAGE = "http://datetime.perl.org/"
DEPENDS = "liblist-moreutils-perl-native libparams-validate-perl-native"
RDEPENDS_${PN} = "liblist-moreutils-perl libparams-validate-perl"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/DateTime-Locale-${PV}.tar.gz"
SRC_URI[md5sum] = "8ba6a4b70f8fa7d987529c2e2c708862"
SRC_URI[sha256sum] = "8aa1b8db0baccc26ed88f8976a228d2cdf4f6ed4e10fc88c1501ecd8f3ccaf9c"

S = "${WORKDIR}/DateTime-Locale-${PV}"

inherit cpan

BBCLASSEXTEND="native"
