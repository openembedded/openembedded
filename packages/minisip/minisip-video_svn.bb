DESCRIPTION = "SIP user agent, with focus on security - video support"
LICENSE = "GPL"
SECTION = "x11/utils"
DEPENDS = "libsdl-x11 ffmpeg-0.4.9-pre1+cvs${SRCDATE} libglademm libmsip0 libmikey0"
CONFLICTS = "minisip"
PV = "0.6.2+svn${SRCDATE}"

SRC_URI = "svn://svn.minisip.org/minisip/trunk;module=minisip"
S = "${WORKDIR}/minisip"

inherit autotools

EXTRA_OECONF = "--enable-ipaq --enable-video --with-avcodec=${STAGING_INCDIR}/ffmpeg"

do_install_append () {
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${datadir}/applications
	install -m 0644 share/minisip.png ${D}${datadir}/pixmaps/minisip.png
	install -m 0644 share/minisip.desktop ${D}${datadir}/applications/minisip.desktop
}

FILES_${PN} += "${datadir}/minisip"

