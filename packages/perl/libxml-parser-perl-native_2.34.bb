SECTION = "libs"

inherit native

require ${@bb.data.getVar('P', d , 1).replace('-native-', '_')}.bb

DEPENDS = "perl-native expat-native"
EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"
