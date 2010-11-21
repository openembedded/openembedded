DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v8 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPLv3"
DEPENDS = "giflib cairo libtool gtk+ agg libsdl-mixer zlib boost jpeg pango curl freetype \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'ffmpeg', d)} speex"
DEPENDS += "gst-plugins-base"

PR = "r0"

SRC_URI = "ftp://ftp.gnu.org/gnu/${PN}/${PV}/${P}.tar.bz2"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-gui=gtk \
                --enable-renderer=agg \
                ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-media=ffmpeg', d)} \
                --with-plugins-install=system \
		--enable-plugins \
                --disable-dependency-tracking \
                --disable-testsuite \
                --enable-media=ffmpeg \
                --with-speex-incl=${STAGING_INCDIR}/speex/ \
                --with-jpeg-incl=${STAGING_INCDIR} \
                --with-jpeg-lib=${STAGING_LIBDIR} \
                --with-top-level=${STAGING_DIR_HOST}/usr \
		--disable-avm2 \
		--with-npapi-plugindir=${libdir}/mozilla/plugins \
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
TARGET_CC_ARCH_append = " -I${STAGING_INCDIR}/cairo -I${STAGING_INCDIR}/libxml2 -DHAVE_POLL_H ${@[' -D_BIG_ENDIAN', ' -D_LITTLE_ENDIAN'][bb.data.getVar('SITEINFO_ENDIANNESS', d, 1) == 'le']}"


do_install_append() {
	oe_runmake DESTDIR=${D} install-plugin
}

SRC_URI[md5sum] = "ce57f66e222f7eb1adf7f7b4a1274612"
SRC_URI[sha256sum] = "dcac4b81f81ecd6cc7c5422d7c731fc5c2a7be7fb18b5570a7e6f8fb5fc6e220"
