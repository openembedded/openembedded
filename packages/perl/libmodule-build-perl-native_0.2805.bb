SECTION = "libs"
require libmodule-build-perl_${PV}.bb
inherit native
EXTRA_CPANFLAGS += " EXPATINCPATH='${STAGING_INCDIR}' EXPATLIBPATH='${STAGING_LIBDIR}'"
