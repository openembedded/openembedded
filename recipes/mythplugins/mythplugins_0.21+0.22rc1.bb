inherit qmake2 qt4x11

DEFAULT_PREFERENCE = "-1"

PV = "0.21+0.22rc1"
PR = "r0"
DEPENDS = "flac taglib mythtv libvorbis libexif libvisual libsdl-x11 libcdaudio"
# to add libcdparanoia

# todo: add mythweb

PACKAGES =+ "mythmovies mythnews mythweather"

RDEPENDS_${PN} = "mythmovies mythnews mythweather"

FILES_mythmovies = "${libdir}/mythtv/plugins/libmythmovies.so \
	${bindir}/ignyte \
	${datadir}/mythtv/mythmovies/ \
	${datadir}/mythtv/themes/default/movies-ui.xml \
	${datadir}/mythtv/themes/default-wide/movies-ui.xml \
	"

FILES_mythmovies-dbg = "${bindir}/.debug/ignyte \
	${libdir}/mythtv/plugins/.debug/libmythmovies.so"


FILES_mythnews = "${libdir}/mythtv/plugins/libmythnews.so \
	${datadir}/mythtv/mythnews/ \
	${datadir}/mythtv/themes/default/enclosures.png \
	${datadir}/mythtv/themes/default/needs-download.png \
	${datadir}/mythtv/themes/default/news-info-bg.png \
	${datadir}/mythtv/themes/default/news-ui.xml \
	"

FILES_mythnews-dbg = "${libdir}/mythtv/plugins/.debug/libmythnews.so"

FILES_mythweather = "${libdir}/mythtv/plugins/libmythweather.so \
	${datadir}/mythtv/mythweather/ \
	${datadir}/mythtv/il8n/mythweather* \
	${datadir}/mythtv/themes/default-wide/mw-background.png \
	${datadir}/mythtv/themes/default-wide/mw-lines.png \
	${datadir}/mythtv/themes/default-wide/mw-map-sat.png \
	${datadir}/mythtv/themes/default-wide/mw-map.png \
	${datadir}/mythtv/themes/default-wide/mw-popup.png \
	${datadir}/mythtv/themes/default-wide/weather-ui.xml \
	${datadir}/mythtv/themes/default/cloudy.png \
	${datadir}/mythtv/themes/default/fair.png \
	${datadir}/mythtv/themes/default/flurries.png \
	${datadir}/mythtv/themes/default/fog.png \
	${datadir}/mythtv/themes/default/logo.png \
	${datadir}/mythtv/themes/default/lshowers.png \
	${datadir}/mythtv/themes/default/mcloudy.png \
	${datadir}/mythtv/themes/default/mw_background.png \
	${datadir}/mythtv/themes/default/mw_checked.png \
	${datadir}/mythtv/themes/default/mw_checked_high.png \
	${datadir}/mythtv/themes/default/mw_lines.png \
	${datadir}/mythtv/themes/default/mw_map-sat.png \
	${datadir}/mythtv/themes/default/mw_map.png \
	${datadir}/mythtv/themes/default/mw_popup.png \
	${datadir}/mythtv/themes/default/mw_shading.png \
	${datadir}/mythtv/themes/default/mw_unchecked.png \
	${datadir}/mythtv/themes/default/mw_unchecked_high.png \
	${datadir}/mythtv/themes/default/mwmain.png \
	${datadir}/mythtv/themes/default/pcloudy.png \
	${datadir}/mythtv/themes/default/rainsnow.png \
	${datadir}/mythtv/themes/default/showers.png \
	${datadir}/mythtv/themes/default/snowshow.png \
	${datadir}/mythtv/themes/default/sunny.png \
	${datadir}/mythtv/themes/default/thunshowers.png \
	${datadir}/mythtv/themes/default/unknown.png \
	${datadir}/mythtv/themes/default/weather-ui.xml \
	${datadir}/mythtv/themes/menus/weather_settings.xml \
	"

FILES_mythweather-dbg = "${libdir}/mythtv/plugins/.debug/libmythweather.so"

SRC_URI = "ftp://ftp.osuosl.org/pub/mythtv/mythplugins-0.22rc1.tar.bz2 \
	file://MythBackend.php.patch;patch=1 \
	file://mythflix.pro.patch;patch=1 \
	file://mythgallery.pro.patch;patch=1 \
	file://mythmovies.pro.patch;patch=1 \
	file://mythnews.pro.patch;patch=1 \
	file://mythweather.pro.patch;patch=1 \
	file://mythzoneminder.pro.patch;patch=1 \
	"

S = "${WORKDIR}/mythplugins-0.22rc1"

QMAKE_PROFILES = "mythplugins.pro"

# Note: a lot of functionality is disabled because it depends on QtOpenGL
# which is not in OE at the moment

EXTRA_OECONF = " \
        --cross-prefix=${TARGET_PREFIX} \
        --sysroot=${STAGING_DIR_HOST} \
        --prefix=${prefix} \
        --with-libdir-name=${STAGING_LIBDIR} \
	--disable-opengl \
	--disable-mytharchive \
	--disable-mythbrowser \
	--disable-mythflix \
	--disable-mythgallery \
	--disable-mythgame \
	--disable-mythmusic \
	--disable-mythvideo \
	--disable-mythzoneminder \
        \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-cxxflags="${TARGET_CXXFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        ${EXTRA_MYTHTVCONF} \
"

do_configure() {
        ${S}/configure --qmake=qmake2 ${EXTRA_OECONF}
}

do_install () {
	oe_runmake install INSTALL_ROOT="${D}"

}

#ALLOW_EMPTY_${PN} = "1"
