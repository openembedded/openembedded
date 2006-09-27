SECTION = "libs"

inherit native

EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"

require liblog-log4perl-perl_${PV}.bb
