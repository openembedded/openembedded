DESCRIPTION = "SFLphone is a SIP/IAX2 compatible softphone for Linux"
SECTION = "libs"
HOMEPAGE = "http://www.sflphone.org"
LICENSE = "GPLv3"

DEPENDS = "blktool alsa-lib expat-native dbus-native openssl \
           pulseaudio libsamplerate0 commoncpp2 ccrtp libzrtpcpp \
           libpcre dbus-c++ dbus-c++-native speex libgsm libyaml"

SRC_URI = "https://projects.savoirfairelinux.com/attachments/download/2162/sflphone-0.9.13.tar.gz \
           file://fix-Makefile.patch"
SRC_URI[md5sum] = "203bae7342b80ab87c1c606232d9b38e"
SRC_URI[sha256sum] = "c264c325c3820189772e63c9cd24ed72f3947f7cb15e8e2d939295ebfcc599fb"

S = "${WORKDIR}/sflphone-${PV}/${PN}"

inherit autotools

EXTRA_OECONF = "--without-networkmanager --without-celt"

FILES_${PN}-dbg += "${libdir}/sflphone/.debug/ ${libdir}/sflphone/*/.debug/"
FILES_${PN} += "${datadir} ${libdir}/sflphone/"

do_configure_prepend() {
	cd ${S}/libs/pjproject
	${S}/libs/pjproject/autogen.sh
	${S}/libs/pjproject/configure ${CONFIGUREOPTS} --disable-ilbc-codec
	make clean
	make dep
	make
	cd ${S}
}