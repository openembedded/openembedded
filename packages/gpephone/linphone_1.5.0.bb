
DESCRIPTION = "SIP-based IP phone"
HOMEPAGE = "http://www.linphone.org/?lang=us"
LICENSE = "GPLv2"
DEPENDS = "libosip2 speex libogg alsa-lib readline"
PR = "r2"

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/1.5.x/source/linphone-${PV}.tar.gz \
           file://linphone-1.5.0.patch;patch=1 \
           file://linphone-pkgconfig.patch;patch=1;pnum=0"

FILES_${PN} += "${datadir}/linphonec"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gnome_ui --disable-gtk-doc --without-ffmpeg \
                --without-sdl --disable-video --enable-alsa \
                --with-osip=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-readline=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --disable-truespeech --disable-manual \
                --disable-glibtest --disable-glib --disable-strict"

do_configure () {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
	oe_runconf SPEEX_LIBS="-lspeex" SPEEX_CFLAGS=" "
}

do_compile () {
	oe_runmake LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool" SPEEX_LIBS="-lspeex" SPEEX_CFLAGS=" "
}

do_install () {
	oe_runmake install "DESTDIR=${D}" "LIBTOOL=${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
}

do_install_append() {
	rm -f ${D}${datadir}/sounds/linphone/hello*.wav
	rm -f ${D}${datadir}/sounds/linphone/rings/oldphone.wav
}

do_stage() {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${TARGET_PREFIX}libtool"
	autotools_stage_all
	rm ${STAGING_LIBDIR}/libquickstream.la	
	rm ${STAGING_LIBDIR}/libmediastreamer.la 
	rm ${STAGING_LIBDIR}/liblinphone.la 
}
