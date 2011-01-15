DESCRIPTION = "SFLphone is a SIP/IAX2 compatible softphone for Linux"
SECTION = "libs"
HOMEPAGE = "http://www.sflphone.org"
LICENSE = "GPLv3"

DEPENDS = "blktool alsa-lib expat-native dbus-native openssl \
           pulseaudio libsamplerate0 commoncpp2 ccrtp libzrtpcpp \
           libpcre dbus-c++ dbus-c++-native sflphone-pjproject speex libgsm"

SRC_URI = "https://projects.savoirfairelinux.com/attachments/download/1977/sflphone-${PV}.tar.gz \
           file://fix-Makefile.patch"
SRC_URI[md5sum] = "f784b5dd02542a5beb07d872d50bd8ee"
SRC_URI[sha256sum] = "eab77836d1205402ad05fc33af2fb9734f69743eabbec4d93fdb5ae7bfdef02b"

S = "${WORKDIR}/sflphone-${PV}/${PN}"

inherit autotools

EXTRA_OECONF = "--without-networkmanager"

FILES_${PN}-dbg += "${libdir}/sflphone/.debug/ ${libdir}/sflphone/*/.debug/"
FILES_${PN} += "${datadir} ${libdir}/sflphone/"

