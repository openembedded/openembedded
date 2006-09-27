SECTION = "libs"

inherit native

EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"

require libversion-perl_${PV}.bb
