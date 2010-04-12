DESCRIPTION = "SIP-based IP phone (Console edition)"
HOMEPAGE = "http://www.linphone.org/?lang=us"
LICENSE = "GPLv2"
DEPENDS = "libosip2 speex libogg alsa-lib readline"
PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/unstable/source/linphone-${PV}.tar.gz \
           file://conf.patch;patch=1"

S = "${WORKDIR}/linphone-${PV}"

FILES_${PN} += "${datadir}/linphonec"

inherit autotools

EXTRA_OECONF = "--disable-gnome_ui --disable-gtk-doc --without-ffmpeg \
                --without-sdl --disable-video --enable-alsa \
                --with-osip=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-readline=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-speex=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --disable-truespeech --disable-manual \
                --disable-glibtest --disable-glib"

do_install_append() {
	rm -f ${D}${datadir}/sounds/linphone/hello*.wav
	rm -f ${D}${datadir}/sounds/linphone/rings/oldphone.wav
}

SRC_URI[md5sum] = "5e87231bc214a003a7d2c3a998ea6a8e"
SRC_URI[sha256sum] = "6855707d72e64ebdec3907fbaaa5d031255cb4b1118159d4b59f26b3704b6929"
