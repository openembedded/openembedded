SECTION = "libs"

inherit native

EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"

require liblog-dispatch-perl_${PV}.bb
