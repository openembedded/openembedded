require lua5.1_${PV}.bb
inherit native

DEPENDS = "readline-native"

do_stage () {
    oe_libinstall -C src liblua ${STAGING_LIBDIR}/
    install -d ${STAGING_INCDIR}/
    install -m 0644 src/lua.h src/luaconf.h src/lualib.h src/lauxlib.h ${STAGING_INCDIR}/
}  

