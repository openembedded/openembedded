DESCRIPTION = "The Battle for Wesnoth is a turn-based strategy game with a fantasy theme."
HOMEPAGE = "http://www.wesnoth.org/"
SECTION = "games"
LICENSE = "GPL"

DEPENDS = "freetype libsdl-image libsdl-mixer libsdl-net libsdl-ttf zlib boost imagemagick-native pango libpng"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/wesnoth/${PN}-${PV}.tar.bz2;name=tarball"
SRC_URI[tarball.md5sum] = "493826bbd9ba355930765a7e8fe3749a"
SRC_URI[tarball.sha256sum] = "7ef047ae364278a5bf9bdc69228f77d825f793f1c4d9adae8b47f0882e7f30d7"

ARM_INSTRUCTION_SET = "arm"

inherit cmake

EXTRA_OECMAKE = "\
	-DGUI=tiny \
	-DENABLE_EDITOR=ON \
	-DENABLE_LOW_MEM=ON \
	-DENABLE_FRIBIDI=OFF \
	\
	-DCMAKE_BUILD_TYPE=Debug \
	"
	
PACKAGES = "wesnoth-editor wesnoth-doc wesnoth-music wesnoth-sounds \
	wesnoth-aoi wesnoth-did wesnoth-ei wesnoth-httt wesnoth-l \
	wesnoth-nr wesnoth-sof wesnoth-sotbe wesnoth-thot wesnoth-trow \
	wesnoth-tsg wesnoth-tb wesnoth-utbs wesnoth-low\
	wesnoth-data \
	wesnoth-all-campaigns \
	wesnoth-all \
	wesnoth wesnoth-dbg \
	wesnothd \
	"

DESCRIPTION_wesnoth-editor = "Map Editor for The Battle for Wesnoth"
DESCRIPTION_wesnoth-all = "The Battle for Wesnoth with all campaigns, music and sounds"
DESCRIPTION_wesnoth-all-campaigns = "The Battle for Wesnoth with all campaigns."
DESCRIPTION_wesnoth-sounds = "Optional sound package for The Battle for Wesnoth"
DESCRIPTION_wesnoth-music = "Optional music package for The Battle for Wesnoth"
DESCRIPTION_wesnoth-data = "Mandatory data package for The Battle for Wesnoth"
DESCRIPTION_wesnothd = "Optional Battle for Wesnoth server"

do_configure_prepend(){
	export HOST_SYS="${HOST_SYS}"
	export BUILD_SYS="${BUILD_SYS}"
	export STAGING_LIBDIR="${STAGING_LIBDIR}"
	export STAGING_INCDIR="${STAGING_INCDIR}"
	rm -f ${S}/cmake/FindBoost.cmake
}

do_install_append() {
	#ugly hack but otherwise it would have required to
	#have MANDIR:STRING=share/man that would require a 
	#second python function
	if [ -d ${D}${prefix}/man ];then
		mv ${D}${prefix}/man ${D}${mandir}
	fi
}

RDEPENDS_wesnoth = "wesnoth-data libpng"

RDEPENDS_wesnoth-editor = "wesnoth-data"

RDEPENDS_wesnoth-all-campaigns = "wesnoth \
	wesnoth-aoi wesnoth-did wesnoth-ei wesnoth-httt wesnoth-l \
	wesnoth-nr wesnoth-sof wesnoth-sotbe wesnoth-thot wesnoth-trow \
	wesnoth-tsg wesnoth-tb wesnoth-utbs wesnoth-low"

# Installing wesnoth-all should pull everything in (like in Debian).
RDEPENDS_wesnoth-all = "wesnoth wesnoth-sounds wesnoth-music"

FILES_wesnoth-music = "\
	${datadir}/wesnoth/data/core/music \
"

FILES_wesnoth-sounds = "\
	${datadir}/wesnoth/data/core/sounds \
"

# Picks up remaining translations and data. Must be packaged after
# wesnoth-music, wesnoth-sounds and all campaigns.
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
	${datadir}/applications/wesnoth.desktop \
	${datadir}/pixmaps/wesnoth-icon.png \
"

FILES_wesnothd = "\
	${bindir}/wesnothd \
"

FILES_wesnoth-low ="\
       ${datadir}/wesnoth/data/campaigns/Legend_of_Wesmere \
       ${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-aoi.mo \
"

FILES_wesnoth-editor = "\
	${bindir}/wesnoth_editor \
	${datadir}/applications/wesnoth_editor.desktop \
	${datadir}/pixmaps/wesnoth_editor-icon.png \
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
