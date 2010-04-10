require libdbd-mysql-perl.inc

DEPENDS = "libdbi-perl mysql"
RDEPENDS = "perl-module-data-dumper \
            libdbi-perl \
            perl-module-scalar-util \
            perl-module-file-spec \
            perl-module-storable \
            perl-module-test-simple"

EXTRA_OECONF = "    --mysql_config=${STAGING_BINDIR_CROSS}/mysql_config"

CFLAGS_append = " -I${STAGING_INCDIR}/mysql"

SRC_URI[md5sum] = "a63c9f73afef70b6c80d899424b003e9"
SRC_URI[sha256sum] = "7068295a5e35ed7dcf20446bee6d80a8de8ba7af5eb5fa35c0b60135c3445c2f"
