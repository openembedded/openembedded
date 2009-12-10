DESCRIPTION = "SIP-based IP phone (console edition)"
HOMEPAGE = "http://www.linphone.org/?lang=us"
SECTION = "x11/utils"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "intltool libosip2 speex libogg alsa-lib readline libexosip2 gtk+"
DEPENDS_${PN} = "liblinphone"
DEPENDS_${PN}c = "liblinphone readline"
DEPENDS_liblinphone = "libmediastreamer libortp libosip2"
#DEPENDS_libquickstream = "speex libmediastreamer alsa-lib"
DEPENDS_libmediastreamer = "speex libogg alsa-lib libortp"

RDEPENDS_${PN} = "liblinphone"
RDEPENDS_${PN}c = "liblinphone readline"
RDEPENDS_liblinphone = "libmediastreamer libortp libosip2"
#RDEPENDS_libquickstream = "speex libmediastreamer libasound"
RDEPENDS_libmediastreamer = "speex libogg libasound libortp"

PROVIDES += "linphone linphonec liblinphone"

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/3.1.x/sources/linphone-${PV}.tar.gz \
	file://b64_assert.patch;patch=1 \
	file://preferences-segv.patch;patch=1 \
	"

S = "${WORKDIR}/linphone-${PV}"

inherit autotools pkgconfig

export PKG_CONFIG=${STAGING_BINDIR_NATIVE}/pkg-config

EXTRA_OECONF = "--disable-gtk-doc \
                --without-ffmpeg --disable-video \
                --enable-alsa \
                --with-osip=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-readline=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --with-speex=${STAGING_DIR_HOST}${layout_exec_prefix} \
                --disable-truespeech --disable-manual \
		--enable-console_ui=yes --enable-gtk_ui=yes \
		--with-realprefix=/usr \
		"

PARALLEL_MAKE = ""

do_stage () {
        install -d ${STAGING_DATADIR}/aclocal
        oe_libinstall -a -so liblinphone ${STAGING_LIBDIR}
        install -d ${STAGING_INCDIR}/linphone
        install -m 0644 ${S}/coreapi/linphonecore.h ${STAGING_INCDIR}/linphone
        install -m 0644 ${S}/coreapi/lpconfig.h ${STAGING_INCDIR}/linphone
        oe_libinstall -a -so libmediastreamer ${STAGING_LIBDIR}
#        oe_libinstall -a -so libquickstream ${STAGING_LIBDIR}
        install -d ${STAGING_INCDIR}/mediastreamer2
        install -m 0644 ${S}/mediastreamer2/include/mediastreamer2/*.h ${STAGING_INCDIR}/mediastreamer2
        install -d ${STAGING_INCDIR}/ortp
        oe_libinstall -a -so libortp ${STAGING_LIBDIR}/
        install -m 0644 ${S}/oRTP/include/ortp/*.h ${STAGING_INCDIR}/ortp/
        autotools_stage_all
}

PACKAGES += "linphonec linphone-rings liblinphone libmediastreamer libortp"

FILES_${PN} = "${bindir}/linphone-3 \ 
	    ${bindir}/linphone \
            ${datadir}/linphone \
 	    ${datadir}/pixmaps \
	    ${datadir}/applications \
	    ${datadir}/gnome/apps \
	    ${datadir}/sounds/linphone/hello8000.wav \
	    ${datadir}/sounds/linphone/hello16000.wav \
	    ${datadir}/images/nowebcamCIF.jpg \
	    "
FILES_${PN}c = "${bindir}/linphonec ${bindir}/linphonecsh ${bindir}/sipomatic ${datadir}/sounds/linphone/ringback.wav"
FILES_${PN}-rings = "${datadir}/sounds/linphone/rings"
FILES_liblinphone = "${libdir}/liblinphone.so.*"
#FILES_libquickstream = "${libdir}/libquickstream.so.*"
FILES_libmediastreamer = "${libdir}/libmediastreamer.so.* /usr/libexec/mediastream"
FILES_libortp = "${libdir}/libortp.so.*"
FILES_${PN}-dev += "${libdir}/*.a ${libdir}/*.la ${libdir}/pkgconfig ${includedir}"

