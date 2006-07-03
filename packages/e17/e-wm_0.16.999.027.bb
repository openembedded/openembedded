DESCRIPTION = "E17 - the Enlightenment Window Mananger"
DEPENDS = "evas-x11 ecore-x11 edje eet embryo e"
LICENSE = "MIT"
PR = "r3"

inherit e update-alternatives

SRC_URI = "${E_URI}/enlightenment-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           file://Xsession.d/98enlightenment"

S = "${WORKDIR}/enlightenment-${PV}"

PROFILE = "LOWRES_PDA"
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
}

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/Xsession.d/98enlightenment ${D}/${sysconfdir}/X11/Xsession.d
}

ALTERNATIVE_PATH = "${bindir}/enlightenment"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "16"
