require intltool.inc

RDEPENDS = "perl-module-text-wrap perl-module-re"
RRECOMMENDS = "perl-modules"

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://intltool-0.35.5-polkit.patch;patch=1"

SRC_URI[md5sum] = "f52d5fa7f128db94e884cd21dd45d2e2"
SRC_URI[sha256sum] = "38bd74418bbac5a34884221e2b710a81876d445d8acfc7d22bde67fe882f96d8"
