DESCRIPTION = "The Battle for Wesnoth is a turn-based strategy game with a fantasy theme."
HOMEPAGE = "http://www.wesnoth.org/"
SECTION = "games"
LICENSE = "GPL"

DEPENDS = "freetype libsdl-image libsdl-mixer libsdl-net libsdl-ttf zlib boost imagemagick-native pango libpng lua5.1"
INC_PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/wesnoth/wesnoth-${PV}.tar.bz2"
S = "${WORKDIR}/wesnoth-${PV}"

ARM_INSTRUCTION_SET = "arm"

inherit cmake

EXTRA_OECMAKE = "\
	-DENABLE_EDITOR=ON \
	-DENABLE_LOW_MEM=ON \
	-DENABLE_FRIBIDI=OFF \
	\
	-DCMAKE_BUILD_TYPE=Debug \
	"
	
PACKAGES = "${PN}-editor ${PN}-doc ${PN}-music ${PN}-sounds \
	${PN}-aoi ${PN}-did ${PN}-ei ${PN}-httt ${PN}-l \
	${PN}-nr ${PN}-sof ${PN}-sotbe ${PN}-thot ${PN}-trow \
	${PN}-tsg ${PN}-tb ${PN}-utbs ${PN}-low\
	${PN}-data \
	${PN}-all-campaigns \
	${PN}-all \
	${PN} ${PN}-dbg \
	${PN}-server \
	"

DESCRIPTION_${PN}-editor = "Map Editor for The Battle for ${PN}"
DESCRIPTION_${PN}-all = "The Battle for ${PN} with all campaigns, music and sounds"
DESCRIPTION_${PN}-all-campaigns = "The Battle for ${PN} with all campaigns."
DESCRIPTION_${PN}-sounds = "Optional sound package for The Battle for ${PN}"
DESCRIPTION_${PN}-music = "Optional music package for The Battle for ${PN}"
DESCRIPTION_${PN}-data = "Mandatory data package for The Battle for ${PN}"
DESCRIPTION_${PN}-server = "Optional Battle for Wesnoth server"

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

RDEPENDS_${PN} = "${PN}-data libpng"

RDEPENDS_${PN}-editor = "${PN}-data"

RDEPENDS_${PN}-all-campaigns = "${PN} \
	${PN}-aoi ${PN}-did ${PN}-ei ${PN}-httt ${PN}-l \
	${PN}-nr ${PN}-sof ${PN}-sotbe ${PN}-thot ${PN}-trow \
	${PN}-tsg ${PN}-tb ${PN}-utbs ${PN}-low"

# Installing wesnoth-all should pull everything in (like in Debian).
RDEPENDS_${PN}-all = "${PN} ${PN}-sounds ${PN}-music"

FILES_${PN}-music = "\
	${datadir}/wesnoth/data/core/music \
"

FILES_${PN}-sounds = "\
	${datadir}/wesnoth/data/core/sounds \
"

# Picks up remaining translations and data. Must be packaged after
# wesnoth-music, wesnoth-sounds and all campaigns.
FILES_${PN}-data = "\
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

FILES_${PN}-server = "\
	${bindir}/wesnothd \
"

FILES_${PN}-low ="\
       ${datadir}/wesnoth/data/campaigns/Legend_of_Wesmere \
       ${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-aoi.mo \
"

FILES_${PN}-editor = "\
	${bindir}/wesnoth_editor \
	${datadir}/applications/wesnoth_editor.desktop \
	${datadir}/pixmaps/wesnoth_editor-icon.png \
"

FILES_${PN}-aoi = "\
	${datadir}/wesnoth/data/campaigns/An_Orcish_Incursion \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-aoi.mo \
"

FILES_${PN}-did = "\
	${datadir}/wesnoth/data/campaigns/Descent_Into_Darkness \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-did.mo \
"

FILES_${PN}-ei = "\
	${datadir}/wesnoth/data/campaigns/Eastern_Invasion \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-ei.mo \
"

FILES_${PN}-httt = "\
	${datadir}/wesnoth/data/campaigns/Heir_To_The_Throne \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-httt.mo \
"

FILES_${PN}-l = "\
	${datadir}/wesnoth/data/campaigns/Liberty \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-l.mo \
"

FILES_${PN}-nr = "\
	${datadir}/wesnoth/data/campaigns/Northern_Rebirth \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-nr.mo \
"

FILES_${PN}-sof = "\
	${datadir}/wesnoth/data/campaigns/Sceptre_Of_Fire \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-sof.mo \
"

FILES_${PN}-sotbe = "\
	${datadir}/wesnoth/data/campaigns/Son_Of_The_Black_Eye \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-sotbe.mo \
"

FILES_${PN}-thot = "\
	${datadir}/wesnoth/data/campaigns/The_Hammer_Of_Thursagan \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-thot.mo \
"

FILES_${PN}-trow = "\
	${datadir}/wesnoth/data/campaigns/The_Rise_Of_Wesnoth \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-trow.mo \
"

FILES_${PN}-tsg = "\
	${datadir}/wesnoth/data/campaigns/The_South_Guard \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-tsg.mo \
"

FILES_${PN}-tb = "\
	${datadir}/wesnoth/data/campaigns/Two_Brothers \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-tb.mo \
"

FILES_${PN}-utbs = "\
	${datadir}/wesnoth/data/campaigns/Under_the_Burning_Suns \
	${datadir}/wesnoth/translations/*/LC_MESSAGES/wesnoth-utbs.mo \
"
