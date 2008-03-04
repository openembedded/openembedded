DEPENDS = "mysql"

export CFLAGS_append=" -I${STAGING_INCDIR}/mysql "

EXTRA_OECONF = " --host=${TARGET_SYS} --prefix=${STAGING_DIR_HOST}${layout_prefix} --enable-mysql"

