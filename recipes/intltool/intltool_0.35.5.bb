require intltool.inc

RDEPENDS = "perl-module-text-wrap perl-module-re"
RRECOMMENDS = "perl-modules"

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://intltool-0.35.5-polkit.patch;patch=1"
