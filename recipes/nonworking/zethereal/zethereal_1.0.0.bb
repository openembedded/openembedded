DESCRIPTION = "The network packet dissector Ethereal, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-1.2 openssl"
HOMEPAGE = "http://www.cartel-info.fr/pbiondi/zaurus/"
APPNAME = "zethereal"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"
PR = "r0"

inherit autotools qmake_base

EXTRA_OECONF = "--disable-ethereal \
                --enable-tethereal \
                --disable-editcap \
                --disable-mergecap \
                --disable-text2pcap \
                --disable-idl2eth \
                --without-ucdsnmp \
                --disable-usr-local \
                --with-pcap=${STAGING_LIBDIR}/.. \
                --with-zlib=${STAGING_LIBDIR}/.. \
                --without-x"

export GLIB_CONFIG = "${STAGING_BINDIR_CROSS}/glib-config"

CFLAGS += "-I${STAGING_INCDIR}/glib-1.2"
LIBS += "-lglib-1.2"

SRC_URI = "http://www.cartel-info.fr/pbiondi/zaurus/ethereal-0.9.5.tar.gz;name=ethereal \
           http://www.cartel-info.fr/pbiondi/zaurus/zethereal-1.0.tar.gz;name=zethereal"
S = "${WORKDIR}/ethereal-0.9.5"

SRC_URI[ethereal.md5sum] = "a7a02706c0f22e56a45bd8999dbb35e3"
SRC_URI[ethereal.sha256sum] = "793ee1a770b6388dce98b7f02eae69b31a8b2172dc69ff3b957376f7df6e8d79"
SRC_URI[zethereal.md5sum] = "d9107c91098f231350c2abf91d4fcb82"
SRC_URI[zethereal.sha256sum] = "e13b931584a9d27d77186c15fac60a7f3f8934af375d8640c44d2e9bc7adc0b4"

do_compile() {
	oe_runmake SUBDIRS="wiretap"
	mv ${WORKDIR}/qtopia .
	${AR} r libzethereal.a packet-*.o afn.o asn1.o column.o conditions.o     \
                capture_stop_conditions.o follow.o in_cksum.o ipproto.o pcap-u   \
                til.o prefs.o print.o ps.o ptvcursor.o reassemble.o ringbuffer.o \
                util.o xdlc.o xmlstub.o register.o
	cd qtopia
	qmake -spec ${QMAKESPEC} zethereal.pro && oe_runmake
}

do_stage() {
	:
}

do_install() {
	:
}

