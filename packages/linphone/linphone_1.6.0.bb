DESCRIPTION = "SIP-based IP phone (console edition)"
HOMEPAGE = "http://www.linphone.org/?lang=us"
LICENSE = "GPL-2"
SECTION = "x11/utils"
PROVIDES = "linphone linphonec liblinphone"
DEPENDS = "intltool libosip2 speex libogg alsa-lib readline"
# for GPE version perhaps use this:
#DEPENDS = "intltool libosip2 speex libogg alsa-lib readline gtk+ libgnomeui"
PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/1.6.x/sources/linphone-${PV}.tar.gz \
           http://download.devbase.at/voip/linphone-1.6.0-pl0.patch;patch=1"

S = "${WORKDIR}/linphone-${PV}"

PACKAGES += "linphonec linphone-rings liblinphone libquickstream libmediastreamer libortp"

FILES_${PN} = "${bindir}/linphone ${datadir}/pixmaps ${datadir}/applications ${datadir}/gnome/apps"
DEPENDS_${PN}  = "liblinphone"
RDEPENDS_${PN} = "liblinphone"
# for GPE version perhaps use these:
#DEPENDS_${PN}  = "liblinphone gtk+ libgnomeui"
#RDEPENDS_${PN} = "liblinphone gtk+ libgnomeui"

FILES_${PN}c = "${bindir}/linphonec ${bindir}/sipomatic ${datadir}/sounds/linphone/ringback.wav"
DEPENDS_${PN}c  = "liblinphone readline"
RDEPENDS_${PN}c = "liblinphone readline"

FILES_${PN}-rings = "${datadir}/sounds/linphone/rings"

FILES_liblinphone = "${libdir}/liblinphone.so*"
DEPENDS_liblinphone  = "libquickstream libmediastreamer libortp libosip2"
RDEPENDS_liblinphone = "libquickstream libmediastreamer libortp libosip2"

FILES_libquickstream = "${libdir}/libquickstream.so*"
DEPENDS_libquickstream  = "speex libmediastreamer alsa-lib"
RDEPENDS_libquickstream = "speex libmediastreamer libasound"

FILES_libmediastreamer = "${libdir}/libmediastreamer.so*"
DEPENDS_libmediastreamer  = "speex libogg alsa-lib libortp"
RDEPENDS_libmediastreamer = "speex libogg libasound libortp"

FILES_libortp = "${libdir}/libortp.so*"

FILES_${PN}-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/pkgconfig ${includedir}"

inherit autotools

EXTRA_OECONF = "--disable-gtk-doc \
                --without-ffmpeg --disable-video --without-sdl \
                --enable-alsa \
                --with-osip=${STAGING_DIR}/${HOST_SYS} \
                --with-readline=${STAGING_DIR}/${HOST_SYS} \
                --with-speex=${STAGING_DIR}/${HOST_SYS} \
                --disable-truespeech --disable-manual \
                --disable-gnome_ui"
# for GPE version probably remove the last line above

#export SPEEX_CFLAGS=-I${STAGING_INCDIR}
#export SPEEX_LIBS="-L${STAGING_LIBDIR} -lspeex"
export PKG_CONFIG=/usr/bin/pkg-config

do_install_append() {
#	rm -f ${D}${datadir}/sounds/linphone/rings/oldphone.wav
}

do_stage () {
	install -d ${STAGING_DATADIR}/aclocal

	oe_libinstall -a -so liblinphone ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/linphone
	install -m 0644 ${S}/coreapi/linphonecore.h ${STAGING_INCDIR}/linphone
	install -m 0644 ${S}/coreapi/lpconfig.h ${STAGING_INCDIR}/linphone
        
	oe_libinstall -a -so libmediastreamer ${STAGING_LIBDIR}
	oe_libinstall -a -so libquickstream ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/mediastreamer2
	install -m 0644 ${S}/mediastreamer2/include/mediastreamer2/*.h ${STAGING_INCDIR}/mediastreamer2
        
	install -d ${STAGING_INCDIR}/ortp
	oe_libinstall -a -so libortp ${STAGING_LIBDIR}/
	install -m 0644 ${S}/oRTP/include/ortp/*.h ${STAGING_INCDIR}/ortp/
}
