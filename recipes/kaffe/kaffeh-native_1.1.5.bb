SRC_URI = "http://www.kaffe.org/ftp/pub/kaffe/v1.1.x-development/kaffe-${PV}.tar.gz"
S = "${WORKDIR}/kaffe-${PV}"
PR = "r3"

require kaffe.inc

RDEPENDS_${PN} = ""

inherit native

EXTRA_OECONF = "--disable-alsatest \
	--disable-esdtest \
	--disable-sound \
	--with-jikes \
	--without-classpath-gtk-awt \
	--without-gmp \
	--enable-pure-java-math \
	--disable-native-awt \
	--disable-sound \
	--without-x \
	--without-kaffe-x-awt \
	--disable-debug \
	--disable-gcj"

do_stage() {
	install -m 0755 kaffe/kaffeh/kaffeh ${STAGING_BINDIR}/

	install -d ${STAGING_DATADIR}/kaffeh
	install -m 0755 libraries/javalib/*.jar ${STAGING_DATADIR}/kaffeh/
}

SRC_URI[md5sum] = "928c578d4808012fe5ba5587071d2aa2"
SRC_URI[sha256sum] = "f4ed45720d76f5182f2dede135c1856ad01bdf9875f54459b6baa1071af67280"
