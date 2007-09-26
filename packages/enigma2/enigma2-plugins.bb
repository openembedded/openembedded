DESCRIPTION = "Additional plugins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20070926"
PV = "1.0cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-plugins;module=enigma2-plugins;method=pserver"
FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "

DESCRIPTION_append_enigma2-plugin-extensions-antiscrollbar = "overlays scrollbars on your tvscreen."
DESCRIPTION_append_enigma2-plugin-extensions-dyndns = "is a client for www.dyndns.org."
DESCRIPTION_append_enigma2-plugin-extensions-lastfm = "is a client to use last.fm, the social music revolution."
DESCRIPTION_append_enigma2-plugin-extensions-logomanager = "manages logos to display at boottime or radiomode."
DESCRIPTION_append_enigma2-plugin-extensions-movietagger = "adds tags to recorded movies, to sort a large list of movies."
DESCRIPTION_append_enigma2-plugin-extensions-netcaster = "is a player for network and internet streams."
DESCRIPTION_append_enigma2-plugin-extensions-simplerss = "is a simple rss viewer for the enigma2 gui."
DESCRIPTION_append_enigma2-plugin-extensions-vlcplayer = "plays and transcodes movies from your pc."
DESCRIPTION_append_enigma2-plugin-extensions-webinterface = "lets you control your dreambox from a web browser."
DESCRIPTION_append_enigma2-plugin-extensions-wirelesslan = " is a Wireless LAN Configuration Tool."
DESCRIPTION_append_enigma2-plugin-extensions-fritzcall = "show incoming calls on your TV (requires an AVM Fritz!box)."

RDEPENDS_enigma2-plugin-extensions-vlcplayer = "neon (>= 0.26.0-r1) gst-plugin-neonhttpsrc"
RDEPENDS_enigma2-plugin-extensions-webinterface = "twisted-web2"
RDEPENDS_enigma2-plugin-extensions-fritzcall = "twisted-web2 twisted-web"

inherit autotools

S = "${WORKDIR}/enigma2-plugins"

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', '%s ', recursive=True, match_path=True, prepend=True, extra_depends = "enigma2")
}
