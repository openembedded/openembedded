# todo: add mythweb
# todo: fix and add mythmusic
# todo: fix and add zoneminder
#ALLOW_EMPTY_${PN} = "1"
DEPENDS = "flac taglib mythtv libvorbis libexif libvisual libsdl-x11 libcdaudio cdparanoia"
RDEPENDS_${PN} = "mytharchive mythbrowser mythflix mythgallery \
        mythgame mythmovies mythnews mythvideo mythweather"
PV = "0.21+0.22rc2"
PR = "r0"

#DEFAULT_PREFERENCE = "-1"

QMAKE_PROFILES = "mythplugins.pro"

SRC_URI = "ftp://ftp.osuosl.org/pub/mythtv/mythplugins-0.22rc2.tar.bz2 \
        file://MythBackend.php.patch;patch=1 \
        file://sysroot.patch;patch=1 \
        file://mythplugins_wo_qtopengl.diff;patch=1 \
        file://configure.patch;patch=1 \
        "

S = "${WORKDIR}/mythplugins-0.22rc2"

inherit qmake2 qt4x11

# zoneminder needs sql files
# mythmusic has a problem with cdparanoia and private; from the cdparanoia buglist
# 'private' as a reserved keyword now being enforced by GCC 4.3, causes a build failure (patched in SVN).
EXTRA_OECONF = " \
        --cross-prefix=${TARGET_PREFIX} \
        --sysroot=${STAGING_DIR_HOST} \
        --prefix=${prefix} \
        --with-libdir-name=${STAGING_LIBDIR} \
        --disable-opengl \
        --disable-mythmusic \
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

PACKAGES =+ "mytharchive mytharchive-dbg \
        mythbrowser mythbrowser-dbg \
        mythflix mythflix-dbg \
        mythgallery mythgallery-dbg \
        mythgame mythgame-dbg \
        mythmovies mythmovies-dbg \
        mythnews mythnews-dbg \
        mythvideo mythvideo-dbg \
        mythweather mythweather-dbg"

FILES_mytharchive = "${libdir}/mythtv/plugins/libmytharchive.so \
        ${bindir}/mytharchivehelper \
        ${datadir}/mythtv/i18n/mytharchive* \
        ${datadir}/mythtv/mytharchive/* \
        ${datadir}/mythtv/archiveformat.xml \
        ${datadir}/mythtv/archivemenu.xml \
        ${datadir}/mythtv/archiveutils.xml \
        ${datadir}/mythtv/themes/default/mytharchive-ui.xml \
        ${datadir}/mythtv/themes/default/mythburn-ui.xml \
        ${datadir}/mythtv/themes/default/mythnative-ui.xml \
        ${datadir}/mythtv/themes/default/ma_*.png \
        ${datadir}/mythtv/themes/default-wide/mytharchive-ui.xml \
        ${datadir}/mythtv/themes/default-wide/mythburn-ui.xml \
        ${datadir}/mythtv/themes/default-wide/mythnative-ui.xml \
        "
FILES_mytharchive-dbg = "${bindir}/.debug/mytharchivehelper \
        ${libdir}/mythtv/plugins/.debug/libmytharchive.so"
FILES_mythbrowser = "${libdir}/mythtv/plugins/libmythbrowser.so \
        ${bindir}/mythbrowser \
        ${datadir}/mythtv/i18n/mythbrowser* \
        ${datadir}/mythtv/themes/default/webpage.png \
        ${datadir}/mythtv/themes/default/browser-ui.xml \
        ${datadir}/mythtv/themes/default-wide/browser-ui.xml \
        "
FILES_mythbrowser-dbg = "${libdir}/mythtv/plugins/.debug/libmythbrowser.so"
FILES_mythflix = "${libdir}/mythtv/plugins/libmythflix.so \
        ${datadir}/mythtv/i18n/mythflix* \
        ${datadir}/mythtv/mythflix/* \
        ${datadir}/mythtv/netflix_menu.xml \
        ${datadir}/mythtv/themes/default/mythflix_background.png \
        ${datadir}/mythtv/themes/default/netflix-ui.xml \
        ${datadir}/mythtv/themes/default-wide/netflix-ui.xml \
        ${datadir}/mythtv/themes/default/title_netflix.png \
        ${datadir}/mythtv/themes/default-wide/title_netflix-bg.png \
        ${datadir}/mythtv/themes/default-wide/netflix-bg.png \
        "
FILES_mythflix-dbg = "${libdir}/mythtv/plugins/.debug/libmythflix.so"
FILES_mythgallery = "${libdir}/mythtv/plugins/libmythgallery.so \
        ${datadir}/mythtv/i18n/mythgallery* \
        ${datadir}/mythtv/themes/default/gallery*.png \
        ${datadir}/mythtv/themes/default/gallery-ui.xml \
        ${datadir}/mythtv/themes/default-wide/gallery-ui.xml \
        "
FILES_mythgallery-dbg = "${libdir}/mythtv/plugins/.debug/libmythgallery.so"
FILES_mythgame = "${libdir}/mythtv/plugins/libmythgame.so \
        ${datadir}/mythtv/i18n/mythgame* \
        ${datadir}/mythtv/game_settings.xml \
        ${datadir}/mythtv/themes/default/game-ui.xml \
        ${datadir}/mythtv/themes/default-wide/game-ui.xml \
        "
FILES_mythgame-dbg = "${libdir}/mythtv/plugins/.debug/libmythgame.so"
FILES_mythmovies = "${libdir}/mythtv/plugins/libmythmovies.so \
        ${bindir}/ignyte \
        ${datadir}/mythtv/mythmovies/* \
        ${datadir}/mythtv/i18n/mythmovies* \
        ${datadir}/mythtv/themes/default/movies-ui.xml \
        ${datadir}/mythtv/themes/default-wide/movies-ui.xml \
        "
FILES_mythmovies-dbg = "${bindir}/.debug/ignyte \
        ${libdir}/mythtv/plugins/.debug/libmythmovies.so"
FILES_mythnews = "${libdir}/mythtv/plugins/libmythnews.so \
        ${datadir}/mythtv/mythnews/* \
        ${datadir}/mythtv/i18n/mythnews* \
        ${datadir}/mythtv/themes/default/enclosures.png \
        ${datadir}/mythtv/themes/default/need-download.png \
        ${datadir}/mythtv/themes/default/podcast.png \
        ${datadir}/mythtv/themes/default/news-info-bg.png \
        ${datadir}/mythtv/themes/default/news-ui.xml \
        ${datadir}/mythtv/themes/default-wide/news-ui.xml \
        "
FILES_mythnews-dbg = "${libdir}/mythtv/plugins/.debug/libmythnews.so"
FILES_mythvideo = "${libdir}/mythtv/plugins/libmythvideo.so \
        ${bindir}/mtd \
        ${datadir}/mythtv/mythvideo/* \
        ${datadir}/mythtv/i18n/mythvideo* \
        $(datadir)/mythtv/themes/default/mv_level_none.png \
        $(datadir)/mythtv/themes/default/mv_level_high.png \
        $(datadir)/mythtv/themes/default/mv_results_popup.png \
        $(datadir)/mythtv/themes/default-wide/mv_results_popup.png \
        $(datadir)/mythtv/themes/default/mv_level_low.png \
        $(datadir)/mythtv/themes/default/mv_level_medium.png \
        $(datadir)/mythtv/themes/default/mv_browse_selector.png \
        $(datadir)/mythtv/themes/default-wide/mv_browse_selector.png \
        $(datadir)/mythtv/themes/default-wide/mv_browse_background.png \
        $(datadir)/mythtv/themes/default-wide/mv_browse_nocover_large.png \
        $(datadir)/mythtv/themes/default-wide/mv_itemdetail_popup.png \
        ${datadir}/mythtv/themes/default-wide/movies-ui.xml \
        ${datadir}/mythtv/themes/default/dvd-ui.xml \
        ${datadir}/mythtv/themes/default-wide/dvd-ui.xml \
        ${datadir}/mythtv/themes/default/video-ui.xml \
        ${datadir}/mythtv/themes/default-wide/video-ui.xml \
        ${datadir}/mythtv/themes/default-wide/mv-background.png \
        ${datadir}/mythtv/themes/default-wide/mv-mselect.png \
        ${datadir}/mythtv/themes/default-wide/mv-sel.png \
        ${datadir}/mythtv/themes/default-wide/mv-wait-background.png \
        ${datadir}/mythtv/themes/default-wide/mv-filerequest.png \
        ${datadir}/mythtv/themes/default-wide/mv-other_background.png \
        ${datadir}/mythtv/themes/default-wide/mv-selected.png \
        ${datadir}/mythtv/video_settings.xml \
        ${datadir}/mythtv/videomenu.xml \
        "
FILES_mythvideo-dbg = "${bindir}/.debug/mtd \
        ${libdir}/mythtv/plugins/.debug/libmythvideo.so"
FILES_mythweather = "${libdir}/mythtv/plugins/libmythweather.so \
        ${datadir}/mythtv/mythweather/* \
        ${datadir}/mythtv/i18n/mythweather* \
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
        ${datadir}/mythtv/weather_settings.xml \
        "
FILES_mythweather-dbg = "${libdir}/mythtv/plugins/.debug/libmythweather.so"
