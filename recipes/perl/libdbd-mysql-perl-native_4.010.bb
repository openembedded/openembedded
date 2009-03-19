require libdbd-mysql-perl.inc

DEPENDS = "libdbi-perl-native mysql-native"

EXTRA_OECONF = "    --mysql_config=${STAGING_BINDIR_NATIVE}"

inherit native

