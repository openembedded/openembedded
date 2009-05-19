require gnome-mplayer.inc

SRCDATE = "20080101"
PV = "0.5.3+cvs${SRCDATE}"
PR = "r6"

S = "${WORKDIR}/${PN}"

SRC_URI += "cvs://anonymous@dekorte.homeip.net/data/cvs;module=${PN}"

do_install_append() {
	sed -i "s/OnlyShowIn=GNOME;//" ${D}${datadir}/applications/gnome-mplayer.desktop
}

