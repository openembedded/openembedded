PV = "1.1.5+cvs${CVSDATE}"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://readonly:readonly@cvs.kaffe.org/cvs/kaffe;module=kaffe"
S = "${WORKDIR}/kaffe"

include kaffe.inc

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
