DESCRIPTION = "The Battle for Wesnoth is a turn-based strategy game with a fantasy theme."
HOMEPAGE = "http://www.wesnoth.org/"
SECTION = "games"
LICENSE = "GPL"

DEPENDS = "freetype libsdl-image libsdl-mixer libsdl-net libsdl-ttf zlib boost imagemagick-native"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/wesnoth/${PN}-${PV}.tar.bz2"

EXTRA_OECONF = "\
	--enable-tinygui \
	--enable-editor \
	--enable-lite \
	--enable-lowmem \
	--with-boost=${STAGING_INCDIR} \
	--with-freetype=${STAGING_INCDIR} \
	--without-fribidi \
	--disable-python \
"

inherit autotools

PACKAGES = "wesnoth-editor wesnoth-doc wesnoth-music \
	wesnoth-aoi wesnoth-did wesnoth-ei wesnoth-httt wesnoth-l \
	wesnoth-nr wesnoth-sof wesnoth-sotbe wesnoth-thot wesnoth-trow \
	wesnoth-tsg wesnoth-tb wesnoth-utbs \
	wesnoth-data \
	wesnoth-all \
	wesnoth wesnoth-dbg \
	"

do_install_append() {
	if [ -f ${D}${datadir}/wesnoth/icons ]; then
		rm -rf ${D}${datadir}/wesnoth/icons
	fi
}

RDEPENDS_wesnoth = "wesnoth-data"

RDEPENDS_wesnoth-editor = "wesnoth-data"

RDEPENDS_wesnoth-all = "wesnoth wesnoth-music \
	wesnoth-aoi wesnoth-did wesnoth-ei wesnoth-httt wesnoth-l \
	wesnoth-nr wesnoth-sof wesnoth-sotbe wesnoth-thot wesnoth-trow \
	wesnoth-tsg wesnoth-tb wesnoth-utbs"

# Installing wesnoth-all should pull everything in (like in Debian).
ALLOW_EMPTY_${PN}-all = "1"

FILES_wesnoth-music = "\
	${datadir}/wesnoth/data/core/music \
"

# Picks up remaining translations and data. Must be packaged after
# wesnoth-music and all campaigns.
FILES_wesnoth-data = "\
  ${datadir}/wesnoth/sounds \
  ${datadir}/wesnoth/images \
  ${datadir}/wesnoth/data \
  ${datadir}/wesnoth/fonts \
  ${datadir}/wesnoth/translations \
"

FILES_${PN} = "\
  ${bindir}/wesnoth \
	${datadir}/icons \
	${datadir}/applications \
"

FILES_wesnoth-editor = "\
	${bindir}/wesnoth_editor \
"

FILES_wesnoth-aoi = "\
	${datadir}/wesnoth/data/campaigns/An_Orcish_Incursion \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-aoi.mo \
"

FILES_wesnoth-did = "\
	${datadir}/wesnoth/data/campaigns/Descent_Into_Darkness \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-did.mo \
"

FILES_wesnoth-ei = "\
	${datadir}/wesnoth/data/campaigns/Eastern_Invasion \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-ei.mo \
"

FILES_wesnoth-httt = "\
	${datadir}/wesnoth/data/campaigns/Heir_To_The_Throne \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-httt.mo \
"

FILES_wesnoth-l = "\
	${datadir}/wesnoth/data/campaigns/Liberty \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-l.mo \
"

FILES_wesnoth-nr = "\
	${datadir}/wesnoth/data/campaigns/Northern_Rebirth \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-nr.mo \
"

FILES_wesnoth-sof = "\
	${datadir}/wesnoth/data/campaigns/Sceptre_Of_Fire \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-sof.mo \
"

FILES_wesnoth-sotbe = "\
	${datadir}/wesnoth/data/campaigns/Son_Of_The_Black_Eye \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-sotbe.mo \
"

FILES_wesnoth-thot = "\
	${datadir}/wesnoth/data/campaigns/The_Hammer_Of_Thursagan \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-thot.mo \
"

FILES_wesnoth-trow = "\
	${datadir}/wesnoth/data/campaigns/The_Rise_Of_Wesnoth \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-trow.mo \
"

FILES_wesnoth-tsg = "\
	${datadir}/wesnoth/data/campaigns/The_South_Guard \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-tsg.mo \
"

FILES_wesnoth-tb = "\
	${datadir}/wesnoth/data/campaigns/Two_Brothers \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-tb.mo \
"

FILES_wesnoth-utbs = "\
	${datadir}/wesnoth/data/campaigns/Under_the_Burning_Suns \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-utbs.mo \
"
