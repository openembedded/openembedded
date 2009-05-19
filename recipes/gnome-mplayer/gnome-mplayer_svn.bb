require gnome-mplayer.inc

SRCDATE = "20080101"
PV = "0.9.5+svn${SRCDATE}"
PR = "r6"
S = "${WORKDIR}/trunk"

SRC_URI = "svn://gnome-mplayer.googlecode.com/svn/;module=trunk;proto=http \
    file://ac-gthread.patch;patch=1 \
    file://1.patch;patch=1 \
    file://uchar-for-utf8-check.patch;patch=1 \
    file://non-utf8-id3-fallback.patch;patch=1"

do_install_append() {
	sed -i "s/OnlyShowIn=GNOME;//" ${D}${datadir}/applications/gnome-mplayer.desktop
}

