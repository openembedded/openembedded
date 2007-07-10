DESCRIPTION = "E17 - the Enlightenment Window Mananger"
DEPENDS = "eet evas ecore edje efreet"
LICENSE = "MIT"
PR = "r7"

inherit e update-alternatives

SRC_URI = "${E_URI}/enlightenment-${PV}.tar.gz \
           file://fix-configure.patch;patch=1 \
           file://set-autoscroll-defaults.patch;patch=1 \
           file://Xsession.d/98enlightenment \
           file://applications.menu \
          "

S = "${WORKDIR}/enlightenment-${PV}"

PROFILE = "LOWRES_PDA"
PROFILE_c7x0 = "HIRES_PDA"
PROFILE_tosa = "HIRES_PDA"
PROFILE_spitz = "HIRES_PDA"
PROFILE_akita = "HIRES_PDA"

EXTRA_OECONF = "--with-profile=${PROFILE} \
                --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
                --x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR}"

FILES_${PN} = "${bindir}/* ${libdir}/enlightenment/modules/*/*.edj ${libdir}/enlightenment/modules/*/*.desktop ${libdir}/enlightenment/modules/*/*/*.so ${libdir}/enlightenment/preload/*.so ${datadir} ${sysconfdir} ${libdir}/enlightenment/modules/cpufreq/*/freqset"
FILES_${PN}-dev += "${libdir}/enlightenment/modules/*/*/*.a ${libdir}/enlightenment/modules/*/*/*.la ${libdir}/enlightenment/preload/*.a ${libdir}/enlightenment/preload/*.la"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug/ ${libdir}/enlightenment/preload/.debug/"

do_compile_prepend() {
    find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
    find ${S} -name Makefile | xargs sed -i 's:/usr/X11R6/include:${STAGING_INCDIR}:'
}

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/Xsession.d/98enlightenment ${D}/${sysconfdir}/X11/Xsession.d

        install -d ${D}/${sysconfdir}/xdg/menus
        install -m 644 ${WORKDIR}/applications.menu ${D}/${sysconfdir}/xdg/menus/
}

ALTERNATIVE_PATH = "${bindir}/enlightenment_start"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "16"
