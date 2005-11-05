DESCRIPTION = "The network packet dissector Ethereal, Qt/Embedded based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-1.2 openssl"
MAINTAINER = "Michael 'Mickey' Lauer"
HOMEPAGE = "http://www.cartel-info.fr/pbiondi/zaurus/"
APPNAME = "zethereal"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"
PR = "r0"

inherit autotools qmake-base

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

export GLIB_CONFIG = "${STAGING_BINDIR}/glib-config"

CFLAGS += "-I${STAGING_INCDIR}/glib-1.2"
LIBS += "-lglib-1.2"

SRC_URI = "http://www.cartel-info.fr/pbiondi/zaurus/ethereal-0.9.5.tar.gz \
           http://www.cartel-info.fr/pbiondi/zaurus/zethereal-1.0.tar.gz"
S = "${WORKDIR}/ethereal-0.9.5"

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

