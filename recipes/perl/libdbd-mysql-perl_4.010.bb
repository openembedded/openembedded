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
