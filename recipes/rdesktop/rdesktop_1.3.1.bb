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

SRC_URI[md5sum] = "968a1e3f5161bab80c306df31c54cfb1"
SRC_URI[sha256sum] = "67332a0a16471c1c3592d3e51ae5cc0562f9a2f1b1ab942b493f7d5080bd2c33"
