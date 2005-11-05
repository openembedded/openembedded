LOADLIB = "-DUSE_DLOPEN=1 -fPIC"
DLLIB = "-ldl"
MYLDFLAGS = "${LDFLAGS} -Wl,-E"
MYCFLAGS = "${CFLAGS}"
USERCONF = '-DLUA_USERCONFIG="\"$(LUA)/etc/saconfig.c\"" -DUSE_READLINE'
# EXTRA_LIBS= "-lm -ldl -lreadline # -lhistory -lcurses -lncurses"
EXTRA_LIBS= "-lm -ldl -lreadline"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "'CC=${CC}' 'MYCFLAGS=${MYCFLAGS}' \
		'MYLDFLAGS=${MYLDFLAGS}' 'WARN=' \
		'INSTALL_EXEC=install -m 0755' \
		'INSTALL_DATA=install -m 0644' \
		'STRIP=echo' 'RANLIB=${RANLIB}' \
		'AR=${AR} rcu' 'LD=${LD}' \
		'LOADLIB=${LOADLIB}' 'DLLIB=${DLLIB}' \
		'USERCONF=${USERCONF}' 'EXTRA_LIBS=${EXTRA_LIBS}' \
		'INSTALL_ROOT=${prefix}' 'INSTALL_BIN=${bindir}' \
		'INSTALL_INC=${includedir}' 'INSTALL_MAN=${mandir}/man1' \
		'INSTALL_SHARE=${datadir}/lua'"

do_compile () {
	oe_runmake all so sobin
}

do_stage () {
	oe_libinstall -C lib liblua ${STAGING_LIBDIR}/
	oe_libinstall -C lib liblualib ${STAGING_LIBDIR}/
	install -m 0644 include/lua.h include/lualib.h include/lauxlib.h ${STAGING_INCDIR}/
}

do_install () {
	oe_runmake \
		'INSTALL_ROOT=${D}${prefix}' \
		'INSTALL_BIN=${D}${bindir}' \
		'INSTALL_INC=${D}${includedir}' \
		'INSTALL_MAN=${D}${mandir}/man1' \
		'INSTALL_SHARE=${D}${datadir}/lua' \
		install soinstall
}
