DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v8 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPLv3"
DEPENDS = "giflib cairo libtool gtk+ agg libsdl-mixer zlib boost jpeg pango curl freetype \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'ffmpeg', d)} speex"
DEPENDS += "gst-plugins-base"
          
PR = "r0"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnash/0.8.7/gnash-0.8.7.tar.bz2"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-gui=gtk \
                --enable-renderer=agg \
                ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-media=ffmpeg', d)} \
                --with-plugins-install=system \
		--enable-plugins \
                --disable-dependency-tracking \
                --disable-testsuite \
                --enable-media=ffmpeg \
                --with-speex-incl=${STAGING_INCDIR}/speex \
		--with-cairo-incl=${STAGING_INCDIR}/cairo \
                --with-cairo-lib=${STAGING_LIBDIR} \
                --with-jpeg-incl=${STAGING_INCDIR} \
                --with-jpeg-lib=${STAGING_LIBDIR} \
                --with-top-level=${STAGING_DIR_HOST}/usr \
		--disable-avm2 \
		"

PACKAGES =+ " gnash-browser-plugin libgnashamf libgnashbackend libgnashbase libgnashgeo libgnashgui libgnashplayer libgnashserver "

FILES_gnash-browser-plugin= "${libdir}/mozilla/plugins/*"
FILES_libgnashamf = "${libdir}/gnash/libgnashamf-${PV}.so"
FILES_libgnashbackend = "${libdir}/gnash/libgnashbackend-${PV}.so"
FILES_libgnashbase = "${libdir}/gnash/libgnashbase-${PV}.so"
FILES_libgnashgeo = "${libdir}/gnash/libgnashgeo-${PV}.so"
FILES_libgnashgui = "${libdir}/gnash/libgnashgui-${PV}.so"
FILES_libgnashplayer = "${libdir}/gnash/libgnashplayer-${PV}.so"
FILES_libgnashserver = "${libdir}/gnash/libgnashserver-${PV}.so"

RDEPENDS_${PN}-browser-plugin += "${PN}"

acpaths = " -Imacros"

# Boost lacks defines for lots of archs
TARGET_CC_ARCH_append = " -I${STAGING_INCDIR}/libxml2 -DHAVE_POLL_H ${@[' -D_BIG_ENDIAN', ' -D_LITTLE_ENDIAN'][bb.data.getVar('SITEINFO_ENDIANNESS', d, 1) == 'le']}"


do_install_append() {
	oe_runmake DESTDIR=${D} install-plugin
}

SRC_URI[md5sum] = "039533fec46e46b94ac6b04e33d58f3a"
SRC_URI[sha256sum] = "73b8a7c788511e453add26fd68cebd5818b39f9da21cc7c78e9cef8bc837e896"
