require rdesktop.inc

PR = "${INC_PR}.1"

SRC_URI +="file://configure.patch;patch=1"

# Note - rdesktop 1.3.1 doesn't use autotools - don't make the same
# mistakes I did.. :)

do_configure() {
	${S}/configure \
	--prefix=${prefix} \
	--exec-prefix=${exec_prefix} \
	--bindir=${bindir} \
	--mandir=${mandir} \
	--sharedir=${datadir} \
	--with-x=${STAGING_EXECPREFIXDIR} \
	--with-openssl=${STAGING_EXECPREFIXDIR} \
	--with-oss \
	--without-debug
}

do_compile() {
	oe_runmake 'KEYMAP_PATH=${datadir}/keymaps/'
}

do_install() {
	oe_runmake DESTDIR=${D} install
}
