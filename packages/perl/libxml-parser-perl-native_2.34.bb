SECTION = "libs"
require libxml-parser-perl_${PV}.bb
inherit native
DEPENDS = "perl-native expat-native"
EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"
