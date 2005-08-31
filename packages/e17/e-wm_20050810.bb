DESCRIPTION = "E17 - the Enlightenment Window Mananger"
DEPENDS = "evas-x11 ecore-x11 edje eet embryo e"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
CVSDATE = "${PV}"
PR = "r3"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/apps/e \
           file://Xsession.d/98enlightenment \
           file://fix-configure.patch;patch=1 \
           file://add-menu-autoscroll-options.patch;patch=1 \
           file://remove-large-fonts.patch;patch=1"
S = "${WORKDIR}/e"

inherit autotools

PROFILE = "LORES_PDA"
PROFILE_c7x0 = "HIRES_PDA"
PROFILE_tosa = "HIRES_PDA"
PROFILE_spitz = "HIRES_PDA"
PROFILE_akita = "HIRES_PDA"

EXTRA_OECONF = "--with-profile=${PROFILE} \
                --with-edje-cc=${STAGING_BINDIR}/edje_cc \
                --x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR}"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir}"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/Xsession.d/98enlightenment ${D}/${sysconfdir}/X11/Xsession.d
}
