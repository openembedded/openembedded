require gnome-mplayer.inc

SRCDATE = "20080101"
PV = "0.5.3+svn${SRCDATE}"
PR = "r6"
S = "${WORKDIR}/trunk"

SRC_URI += "svn://gnome-mplayer.googlecode.com/svn/;module=trunk;proto=http"

do_install_append() {
	sed -i "s/OnlyShowIn=GNOME;//" ${D}${datadir}/applications/gnome-mplayer.desktop
}

