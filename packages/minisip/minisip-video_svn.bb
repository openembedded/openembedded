PV = "0.6.2svn${CVSDATE}"
LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r0"
MAINTAINER = "Johan Bilien <jobi@via.ecp.fr>"
CONFLICTS = "minisip"

DESCRIPTION = "SIP user agent, with focus on security - video support"
DEPENDS = "libsdl-x11 ffmpeg-0.4.9-pre1+cvs-${CVSDATE} libglademm libmsip0 libmikey0"
SRC_URI = "svn://svn.minisip.org/var/svn/minisip/trunk;module=minisip"
S = ${WORKDIR}/minisip



FILES_${PN} += "${datadir}/minisip"

inherit autotools

EXTRA_OECONF = "--enable-ipaq --enable-video --with-avcodec=${STAGING_INCDIR}/ffmpeg"

do_install_append () {
	install -d ${D}${datadir}/pixmaps
	install -d ${D}${datadir}/applications
	install -m 0644 share/minisip.png ${D}${datadir}/pixmaps/minisip.png
	install -m 0644 share/minisip.desktop ${D}${datadir}/applications/minisip.desktop
}
