include kaffe.inc

PV = "1.1.4+cvs${CVSDATE}"

inherit native

EXTRA_OECONF += " --without-classpath-gtk-awt \
	--disable-native-awt \
	--disable-sound \
	--without-x \
	--without-kaffe-x-awt \
	--disable-debug \
	--disable-gcj"

do_stage() {
	install -m 0755 kaffe/kaffeh/kaffeh ${STAGING_BINDIR}/
}
