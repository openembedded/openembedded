DESCRIPTION = "SIP-based IP phone (console edition)"
HOMEPAGE = "http://www.linphone.org/?lang=us"
SECTION = "x11/utils"
LICENSE = "GPLv2"

DEPENDS = "intltool libosip2 speex libogg alsa-lib readline"
DEPENDS_${PN} = "liblinphone"
DEPENDS_${PN}c = "liblinphone readline"
DEPENDS_liblinphone = "libquickstream libmediastreamer libortp libosip2"
DEPENDS_libquickstream = "speex libmediastreamer alsa-lib"
DEPENDS_libmediastreamer = "speex libogg alsa-lib libortp"

RDEPENDS_${PN} = "liblinphone"
RDEPENDS_${PN}c = "liblinphone readline"
RDEPENDS_liblinphone = "libquickstream libmediastreamer libortp libosip2"
RDEPENDS_libquickstream = "speex libmediastreamer libasound"
RDEPENDS_libmediastreamer = "speex libogg libasound libortp"

PROVIDES += "linphone linphonec liblinphone"

PR = "r3"

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/1.6.x/sources/linphone-${PV}.tar.gz \
           http://download.devbase.at/voip/linphone-1.6.0-pl0.patch;patch=1 \
           file://linphone-speex.diff;patch=1"

S = "${WORKDIR}/linphone-${PV}"

inherit autotools pkgconfig

export PKG_CONFIG=${STAGING_BINDIR_NATIVE}/pkg-config

EXTRA_OECONF = "--disable-gtk-doc \
                --without-ffmpeg --disable-video --without-sdl \
                --enable-alsa \
                --with-osip=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-readline=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-speex=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --disable-truespeech --disable-manual \
                --disable-gnome_ui"

PARALLEL_MAKE = ""

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
        autotools_stage_all
}

PACKAGES += "linphonec linphone-rings liblinphone libquickstream libmediastreamer libortp"

FILES_${PN} = "${bindir}/linphone ${datadir}/pixmaps ${datadir}/applications ${datadir}/gnome/apps"
FILES_${PN}c = "${bindir}/linphonec ${bindir}/sipomatic ${datadir}/sounds/linphone/ringback.wav"
FILES_${PN}-rings = "${datadir}/sounds/linphone/rings"
FILES_liblinphone = "${libdir}/liblinphone.so.*"
FILES_libquickstream = "${libdir}/libquickstream.so.*"
FILES_libmediastreamer = "${libdir}/libmediastreamer.so.*"
FILES_libortp = "${libdir}/libortp.so.*"
FILES_${PN}-dev += "${libdir}/*.a ${libdir}/*.la ${libdir}/pkgconfig ${includedir}"

