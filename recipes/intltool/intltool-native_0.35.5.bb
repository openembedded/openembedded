require intltool_${PV}.bb

inherit native

export PERL = "/usr/bin/env perl"
SRC_URI_append = " file://intltool-nowarn.patch;patch=1"

DEFAULT_PREFERENCE = "-1"

SRC_URI[md5sum] = "f52d5fa7f128db94e884cd21dd45d2e2"
SRC_URI[sha256sum] = "38bd74418bbac5a34884221e2b710a81876d445d8acfc7d22bde67fe882f96d8"
