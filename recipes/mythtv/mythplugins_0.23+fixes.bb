DESCRIPTION = "plugins for mythtv: A full featured personal video recorder system."
HOMEPAGE = "http://www.mythtv.org"
LICENSE = "GPLv2"

DEPENDS = "flac taglib mythtv libvorbis libexif libvisual virtual/libsdl libcdaudio cdparanoia"
RDEPENDS_${PN} = "mytharchive mythbrowser mythgallery mythgame mythmovies  \
                  mythmusic mythnetvision mythnews mythvideo mythweather mythzoneminder"
RRECOMMENDS_${PN} = "mythweb-lighttpd"

# the apache variant does not work yet, too many issues with apache+php+mysql"
#DEPENDS_mythweb-apache = "mythweb"
#RDEPENDS_mythweb-apache = "apache2"

DEPENDS_mythweb-lighttpd = "mythweb"
RDEPENDS_mythweb-lighttpd = "lighttpd lighttpd-module-cgi lighttpd-module-fastcgi \
        lighttpd-module-rewrite php-cgi lighttpd-module-auth sed"

RDEPENDS_mythnetvision += " python python-mysqldb "

DEPENDS += " fftw fftwf "
RDEPENDS_mythmusic += " libfftw libfftwf "

# for mythweather:
DEPENDS += " libxml-xpath-perl-native libxml-simple-perl-native libdatetime-format-iso8601-perl-native \
	libsoap-lite-perl-native libimage-size-perl-native libdate-manip-perl-native "
RDEPENDS_mythweather += " libxml-xpath-perl libxml-simple-perl libdatetime-format-iso8601-perl \
	libsoap-lite-perl libimage-size-perl libdate-manip-perl "

PR = "svnr${SRCPV}+r0"
PV = "0.23"

SRCREV = "27202"
SRC_URI = "svn://svn.mythtv.org/svn/branches/release-0-23-fixes;module=mythplugins;proto=http \
        file://sysroot.patch \
        file://mythplugins_wo_qtopengl.diff \
        file://configure.patch \
        file://mytharchive.pro.patch \
        "

QMAKE_PROFILES = "mythplugins.pro"

S = "${WORKDIR}/mythplugins"

inherit qmake2 qt4x11

EXTRA_OECONF = " \
        --cross-prefix=${TARGET_PREFIX} \
        --sysroot=${STAGING_DIR_HOST} \
        --prefix=${prefix} \
        --with-libdir-name=${STAGING_LIBDIR} \
        --disable-opengl \
        \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-cxxflags="${TARGET_CXXFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
"

do_configure() {
        ${S}/configure --qmake=qmake2 ${EXTRA_OECONF}
}

do_install () {
        oe_runmake install INSTALL_ROOT="${D}"
	rm -rf `find ${S}/mythweb -type d -name .svn`
#        install -d  ${D}${datadir}/
#        install -d  ${D}${datadir}/apache2
#        install -d  ${D}${datadir}/apache2/htdocs
        install -d  ${D}${sysconfdir}/
#        install -d  ${D}${sysconfdir}/apache2
#        install -d  ${D}${sysconfdir}/apache2/extra
#        cp -R ${S}/mythweb/* ${D}/${datadir}/apache2/htdocs/
#        mv ${S}/mythweb/mythweb.conf.apache ${D}${sysconfdir}/apache2/extra/mythweb.conf
#        sed -i -e s:/var/www/html:/usr/share/apache2/htdocs:g ${D}${sysconfdir}/apache2/extra/mythweb.conf
        install -d  ${D}/www
        install -d  ${D}/www/pages
        cp -R ${S}/mythweb/* ${D}/www/pages/
        mv ${S}/mythweb/mythweb.conf.lighttpd ${D}${sysconfdir}/mythweb.conf
        sed -i -e s:/var/www/html:/www/pages:g ${D}${sysconfdir}/mythweb.conf
}

#pkg_postinst_mythweb-apache () {
#        chgrp -R apache /usr/share/apache2/htdocs/data
#        chmod g+rw /usr/share/apache2/htdocs/data
#        grep mythweb.conf /etc/apache2/httpd.conf || \
#              echo "Include /etc/apache2/extra/mythweb.conf" >>/etc/apache2/httpd.conf
#}

pkg_postinst_mythweb-lighttpd () {
        chgrp -R www-data /var/www/pages
        chmod g+rw /var/www/pages
        grep mythweb.conf /etc/lighttpd.conf || \
                echo "include \"mythweb.conf\"" >>/etc/lighttpd.conf
	sed -i 's:#\( *mod_cgi\):\1:' /etc/lighttpd.conf
	sed -i 's:#\( *mod_fastcgi\):\1:' /etc/lighttpd.conf
	sed -i 's:#\( *mod_rewrite\):\1:' /etc/lighttpd.conf
	sed -i 's:#\( *mod_auth\):\1:' /etc/lighttpd.conf
	sed -i 's:/var/run/lighttpd/mythtv-php-fcgi.socket:/var/run/mythtv-php-fcgi.socket:' /etc/mythweb.conf
}

PACKAGES =+ " \
#        mythweb-apache \
	mythweb-lighttpd \
        mytharchive mytharchive-dbg \
        mythbrowser mythbrowser-dbg \
        mythgallery mythgallery-dbg \
        mythgame mythgame-dbg \
        mythmovies mythmovies-dbg \
        mythmusic mythmusic-dbg \
        mythnetvision mythnetvision-dbg \
        mythnetvision-data \
        mythnews mythnews-dbg \
        mythvideo mythvideo-dbg \
        mythweather mythweather-dbg \
        mythzoneminder mythzoneminder-dbg"

#FILES_mythweb-apache = " \
#	${datadir}/apache2/htdocs/mythweb.* \
#	${datadir}/apache2/htdocs/*/ \
#	${datadir}/apache2/htdocs/*/*/ \
#	${datadir}/apache2/htdocs/*/*/* \
#	${datadir}/apache2/htdocs/*/*/*/* \
#        /etc/apache2/extra/mythweb.conf"

FILES_mythweb-lighttpd = " \
	/www/pages/mythweb.* \
	/www/pages/* \
	/www/pages/*/* \
	/www/pages/*/*/* \
	/www/pages/*/*/*/* \
        /etc/mythweb.conf"

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
        ${datadir}/mythtv/themes/default/mb_progressbar_background.png \
        ${datadir}/mythtv/themes/default/mb_progressbar_fill.png \
        ${datadir}/mythtv/themes/default-wide/mytharchive-ui.xml \
        ${datadir}/mythtv/themes/default-wide/mythburn-ui.xml \
        ${datadir}/mythtv/themes/default-wide/mythnative-ui.xml \
        "
FILES_mytharchive-dbg = "${bindir}/.debug/mytharchivehelper \
        ${libdir}/mythtv/plugins/.debug/libmytharchive.so"

FILES_mythbrowser = "${libdir}/mythtv/plugins/libmythbrowser.so \
        ${bindir}/mythbrowser \
        ${datadir}/mythtv/i18n/mythbrowser* \
        ${datadir}/mythtv/themes/default/browser-ui.xml \
        ${datadir}/mythtv/themes/default-wide/browser-ui.xml \
        "
FILES_mythbrowser-dbg = "${libdir}/mythtv/plugins/.debug/libmythbrowser.so"

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

FILES_mythmusic = "${libdir}/mythtv/plugins/libmythmusic.so \
        ${datadir}/mythtv/mythmusic/* \
        ${datadir}/mythtv/i18n/mythmusic* \
        ${datadir}/mythtv/music_settings.xml \
        ${datadir}/mythtv/musicmenu.xml \
        ${datadir}/mythtv/themes/default/selectionbar.png \
        ${datadir}/mythtv/themes/default/mm_browser_back_reg.png \
        ${datadir}/mythtv/themes/default/music-sel-bg.png \
        ${datadir}/mythtv/themes/default/mm_rip_banner.png \
        ${datadir}/mythtv/themes/default/mm_prev_on.png \
        ${datadir}/mythtv/themes/default/next_button_off.png \
        ${datadir}/mythtv/themes/default/mm_next_pushed.png \
        ${datadir}/mythtv/themes/default/stop_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_folder.png \
        ${datadir}/mythtv/themes/default/mm_left_arrow.png \
        ${datadir}/mythtv/themes/default/rew_button_on.png \
        ${datadir}/mythtv/themes/default/next_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_trans_background.png \
        ${datadir}/mythtv/themes/default/prev_button_off.png \
        ${datadir}/mythtv/themes/default/mm_browser_back_sel.png \
        ${datadir}/mythtv/themes/default/ff_button_off.png \
        ${datadir}/mythtv/themes/default/mm_volume_tick.png \
        ${datadir}/mythtv/themes/default/stop_button_off.png \
        ${datadir}/mythtv/themes/default/mm_progress-fg.png \
        ${datadir}/mythtv/themes/default/mm_rip_background.png \
        ${datadir}/mythtv/themes/default/rew_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_next_off.png \
        ${datadir}/mythtv/themes/default/mm_next_on.png \
        ${datadir}/mythtv/themes/default/pause_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_nothumb.png \
        ${datadir}/mythtv/themes/default/stop_button_on.png \
        ${datadir}/mythtv/themes/default/mm_blackhole_border.png \
        ${datadir}/mythtv/themes/default/mm_prev_pushed.png \
        ${datadir}/mythtv/themes/default/pause_button_on.png \
        ${datadir}/mythtv/themes/default/play_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_progress_foreground.png \
        ${datadir}/mythtv/themes/default/pause_button_off.png \
        ${datadir}/mythtv/themes/default/play_button_off.png \
        ${datadir}/mythtv/themes/default/mm_progress_background.png \
        ${datadir}/mythtv/themes/default/mm_up_arrow.png \
        ${datadir}/mythtv/themes/default/prev_button_on.png \
        ${datadir}/mythtv/themes/default/mm_volume_background.png \
        ${datadir}/mythtv/themes/default/ff_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_prev_off.png \
        ${datadir}/mythtv/themes/default/miniplayer_background.png \
        ${datadir}/mythtv/themes/default/mm_progress-bg.png \
        ${datadir}/mythtv/themes/default/track_info_background.png \
        ${datadir}/mythtv/themes/default/mm_waiting.png \
        ${datadir}/mythtv/themes/default/play_button_on.png \
        ${datadir}/mythtv/themes/default/prev_button_pushed.png \
        ${datadir}/mythtv/themes/default/mm_right_arrow.png \
        ${datadir}/mythtv/themes/default/ff_button_on.png \
        ${datadir}/mythtv/themes/default/mm_down_arrow.png \
        ${datadir}/mythtv/themes/default/next_button_on.png \
        ${datadir}/mythtv/themes/default/mm_rating.png \
        ${datadir}/mythtv/themes/default/rew_button_off.png \
        ${datadir}/mythtv/themes/default/mm-titlelines.png \
        ${datadir}/mythtv/themes/default-wide/music-sel-bg.png \
        ${datadir}/mythtv/themes/default-wide/mm_blackhole_border.png \
        ${datadir}/mythtv/themes/default-wide/mm_volume_background.png \
        ${datadir}/mythtv/themes/default-wide/mm_waiting.png \
        ${datadir}/mythtv/themes/default-wide/mm-titlelines.png \
        ${datadir}/mythtv/themes/default/music-ui.xml \
        ${datadir}/mythtv/themes/default-wide/music-ui.xml \
        "
FILES_mythmusic-dbg = "${libdir}/mythtv/plugins/.debug/libmythmusic.so"

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

FILES_mythnetvision = "${libdir}/mythtv/plugins/libmythnetvision.so \
        ${datadir}/mythtv/mythnetvision/* \
        ${datadir}/mythtv/i18n/mythnetvision* \
        ${datadir}/mythtv/mythnetvision.xml\
        ${datadir}/mythtv/netvisionmenu.xml\
        ${datadir}/mythtv/themes/default/netvision-ui.xml \
        ${datadir}/mythtv/themes/default-wide/netvision-ui.xml \
        "
FILES_mythnetvision-dbg = "${libdir}/mythtv/plugins/.debug/libmythnetvision.so"

FILES_mythvideo = "${libdir}/mythtv/plugins/libmythvideo.so \
        ${bindir}/mtd \
        ${datadir}/mythtv/mythvideo/* \
        ${datadir}/mythtv/i18n/mythvideo* \
        ${datadir}/mythtv/themes/default/md_progress_background.png \
        ${datadir}/mythtv/themes/default/md_rip_banner.png \
        ${datadir}/mythtv/themes/default/mv_level_none.png \
        ${datadir}/mythtv/themes/default/mv_browse_background.png \
        ${datadir}/mythtv/themes/default/mv_itemdetail_popup.png \
        ${datadir}/mythtv/themes/default/mv_filerequest.png  \
        ${datadir}/mythtv/themes/default/mv_level_high.png \
        ${datadir}/mythtv/themes/default/mv_results_popup.png \
        ${datadir}/mythtv/themes/default-wide/mv_results_popup.png \
        ${datadir}/mythtv/themes/default/mv_level_low.png \
        ${datadir}/mythtv/themes/default/mv_level_lowest.png \
        ${datadir}/mythtv/themes/default/mv_level_medium.png \
        ${datadir}/mythtv/themes/default/mv_browse_selector.png \
        ${datadir}/mythtv/themes/default-wide/mv_results_popup.png \
        ${datadir}/mythtv/themes/default-wide/mv_browse_selector.png \
        ${datadir}/mythtv/themes/default-wide/mv_browse_background.png \
        ${datadir}/mythtv/themes/default-wide/mv_browse_nocover_large.png \
        ${datadir}/mythtv/themes/default-wide/mv_itemdetail_popup.png \
        ${datadir}/mythtv/themes/default-wide/movies-ui.xml \
        ${datadir}/mythtv/themes/default/dvd-ui.xml \
        ${datadir}/mythtv/themes/default-wide/dvd-ui.xml \
        ${datadir}/mythtv/themes/default/video-ui.xml \
        ${datadir}/mythtv/themes/default-wide/video-ui.xml \
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

FILES_mythzoneminder = "${libdir}/mythtv/plugins/libmythzoneminder.so \
        ${datadir}/mythtv/zonemindermenu.xml \
        ${datadir}/mythtv/i18n/mythzoneminder* \
        ${datadir}/mythtv/themes/default/zoneminder-ui.xml \
        ${datadir}/mythtv/themes/default/mz_black.png \
        ${datadir}/mythtv/themes/default/mz_browser_back_sel.png \
        ${datadir}/mythtv/themes/default/mz_browser_back_reg.png \
        ${datadir}/mythtv/themes/default/mz_function_popup.png \
        ${datadir}/mythtv/themes/default/mz_testcard.png \
        ${datadir}/mythtv/themes/default-wide/zoneminder-ui.xml \
        "
FILES_mythzoneminder-dbg = "${libdir}/mythtv/plugins/.debug/libmythzoneminder.so"
