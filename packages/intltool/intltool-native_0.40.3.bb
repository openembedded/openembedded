require intltool_${PV}.bb

inherit native
DEPENDS = "libxml-parser-perl-native"

export PERL = "/usr/bin/env perl"
