# This wrapper builds a native version of the Oracal
# Berkeley DB for those packages which need it (e.g.
# perl).

VIRTUAL_NAME = "virtual/db-native"
CONFLICTS = "db3-native"
#PR tracks the non-native package

inherit native

do_package() {
:
}

PACKAGES = ""

do_stage() {
         # The .h files get installed read-only, the autostage
         # function just uses cp -pPR, so do this by hand
         rm -rf ${STAGE_TEMP}
         mkdir -p ${STAGE_TEMP}
         oe_runmake DESTDIR="${STAGE_TEMP}" install_include
         cp -pPRf ${STAGE_TEMP}/${includedir}/* ${STAGING_INCDIR}/.
         rm -rf ${STAGE_TEMP}
         oe_libinstall -so -C .libs libdb-${PVM} ${STAGING_LIBDIR}
         ln -sf libdb-${PVM}.so ${STAGING_LIBDIR}/libdb.so
         ln -sf libdb-${PVM}.a ${STAGING_LIBDIR}/libdb.a
}
