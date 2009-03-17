DESCRIPTION = "SIP-based IP phone (Console edition)"
HOMEPAGE = "http://www.linphone.org/?lang=us"
LICENSE = "GPL-2"
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
