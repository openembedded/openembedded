require libdbd-mysql-perl.inc

DEPENDS = "libdbi-perl-native mysql-native"

EXTRA_OECONF = "    --mysql_config=${STAGING_BINDIR_NATIVE}"

inherit native


SRC_URI[md5sum] = "a63c9f73afef70b6c80d899424b003e9"
SRC_URI[sha256sum] = "7068295a5e35ed7dcf20446bee6d80a8de8ba7af5eb5fa35c0b60135c3445c2f"
