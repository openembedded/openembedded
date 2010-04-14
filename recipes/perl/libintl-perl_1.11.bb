DESCRIPTION = "libintl-perl is an internationalization library for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR= "r2"

SRC_URI = "http://www.cpan.org/authors/id/G/GU/GUIDO/libintl-perl-${PV}.tar.gz"

SRC_URI[md5sum] = "091e05542e36f030c785f2919f05b73f"
SRC_URI[sha256sum] = "71e397949e79eb0f789f73259db5fc7be1e2ba1c604510c8d44b101d7d6e6479"

DEPENDS = "perl"
RDEPENDS = "perl-module-vars perl-module-locale perl-module-io-handle perl-module-symbol perl-module-selectsaver perl-module-io perl-module-integer perl-module-exporter-heavy"

S = "${WORKDIR}/libintl-perl-${PV}"

inherit cpan

BBCLASSEXTEND="native"
