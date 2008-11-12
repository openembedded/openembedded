DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
DEPENDS = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native  \
	libfribidi gstreamer libxmlccwrap libdreamdvd"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-fcntl gst-plugin-decodebin python-stringold \
	gst-plugin-id3demux gst-plugin-mad gst-plugin-ogg gst-plugin-playbin \
	gst-plugin-typefindfunctions gst-plugin-ivorbis gst-plugin-audioconvert \
	gst-plugin-wavparse python-netclient gst-plugin-mpegstream gst-plugin-selector \
	gst-plugin-flac gst-plugin-fluendo-mpegdemux gst-plugin-neonhttpsrc"

RDEPENDS_append_dm7020 = " gst-plugin-ossaudio"
RDEPENDS_append_dm7025 = " gst-plugin-alsa alsa-conf"
RDEPENDS_append_dm8000 = " gst-plugin-alsa alsa-conf gst-plugin-avi gst-plugin-matroska \
	gst-plugin-qtdemux gst-plugin-subparse glibc-gconv-iso8859-15 gst-plugin-cdxaparse"
RDEPENDS_append_dm800 = " gst-plugin-alsa alsa-conf"

# 'forward depends' - no two providers can have the same PACKAGES_DYNAMIC, however both
# enigma2 and enigma2-plugins produce enigma2-plugin-*.
#DEPENDS += "enigma2-plugins"
#PACKAGES_DYNAMIC = "enigma2-plugin-*"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-configurationbackup = "backs up your configuration and restores them optionally."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-extensions-dvdplayer = "libdreamdvd0"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "twisted-web"

PN = "enigma2"
PR = "r0"
SRCDATE = "20081111"

# if you want experimental, use:
#REL_MAJOR="2"
#REL_MINOR="5"
#SUBDIR=
#MODULE=trunk

# if you want a 2.4-based release, use
REL_MAJOR="2"
REL_MINOR="4"
SUBDIR=/branches
MODULE=enigma2_rel${REL_MAJOR}${REL_MINOR}

REL_MINOR_dm8000="5"
SUBDIR_dm8000=
MODULE_dm8000=trunk
PR_dm8000="r0"

PV = "${REL_MAJOR}.${REL_MINOR}git${SRCDATE}"
SRC_URI = "svn://git.opendreambox.org/enigma2${SUBDIR};module=${MODULE};date=${SRCDATE} \
           file://enigma2.sh"

SRC_URI_append_dm7025 = " file://enigma2-disable-iframesearch.patch;patch=1;pnum=1"

S = "${WORKDIR}/${MODULE}"

FILES_${PN} += "${datadir}/fonts"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--enable-maintainer-mode --with-target=native --with-libsdl=no"

do_install_append() {
	install -m 0755 ${WORKDIR}/enigma2.sh ${D}/usr/bin/
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', '%s ', recursive=True, match_path=True, prepend=True)
}

do_stage_append() {
	install -d ${STAGING_INCDIR}/enigma2
	install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/enigma2
	for dir in actions base components driver dvb dvb/lowlevel dvb_ci gdi gui mmi nav python service; do
		install -d ${STAGING_INCDIR}/enigma2/lib/$dir;
		install -m 0644 ${S}/lib/$dir/*.h ${STAGING_INCDIR}/enigma2/lib/$dir;
	done
}
