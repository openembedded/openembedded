SECTION = "libs"

inherit native

EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"

require libdevel-stacktrace-perl_${PV}.bb
