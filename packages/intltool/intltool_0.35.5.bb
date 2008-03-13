require intltool.inc

DEPENDS = "libxml-parser-perl-native"
RDEPENDS = "perl-module-text-wrap perl-module-re"

PR = "r2"

RRECOMMENDS = "perl-modules"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://intltool-0.35.5-polkit.patch;patch=1"
