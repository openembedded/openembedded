DEPENDS += " radlib-mysql"

export CFLAGS_append=" -I${STAGING_INCDIR}/mysql "
export LDFLAGS_append=" -L${STAGING_LIBDIR}/mysql "

EXTRA_OECONF += " --enable-mysql" 

