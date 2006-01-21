DESCRIPTION = "E17 - the Enlightenment Window Mananger"
DEPENDS = "evas-x11 ecore-x11 edje eet embryo e"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r3"

SRC_URI = "http://enlightenment.freedesktop.org/files/enlightenment-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           file://remove-large-fonts.patch;patch=1 \
           file://disable-splash.patch;patch=1 \
           file://Xsession.d/98enlightenment \
           cvs://anonymous@thinktux.net/root;module=e17/apps/e/data/themes;date=20050926"
#           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/apps/e/data/themes/default_entry.edc?rev=1.1 \
#           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/apps/e/data/themes/images/focus.png?rev=1.1 \
#           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/apps/e/data/themes/images/entry.png?rev=1.1 \
#           http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/apps/e/data/themes/images/entry_focus.png?rev=1.1"

S = "${WORKDIR}/enlightenment-${PV}"

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

do_compile_prepend() {
        find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
	find ${S} -name Makefile | xargs sed -i 's:/usr/X11R6/include:${STAGING_INCDIR}:'
	mv "${WORKDIR}/themes/default_entry.edc" "${S}/data/themes/"
	mv "${WORKDIR}/themes/images/focus.png" "${S}/data/themes/images/"
	mv "${WORKDIR}/themes/images/entry.png" "${S}/data/themes/images/"
	mv "${WORKDIR}/themes/images/entry_focus.png" "${S}/data/themes/images/"
}

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/Xsession.d/98enlightenment ${D}/${sysconfdir}/X11/Xsession.d
}
