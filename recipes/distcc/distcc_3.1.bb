DESCRIPTION = "distcc is a parallel build system that distributes \
compilation of C/C++/ObjC code across machines on a network."
SECTION = "devel"
LICENSE = "GPLv2"

PR = "r1"

DEPENDS = "avahi gtk+"
RRECOMMENDS = "avahi-daemon"

SRC_URI = "http://distcc.googlecode.com/files/distcc-${PV}.tar.bz2 \
           file://default \
	   file://distccmon-gnome.desktop \
	   file://distcc"

inherit distutils-base autotools update-rc.d

INITSCRIPT_NAME = "distcc"

EXTRA_OECONF = " --with-gtk --with-avahi ac_cv_path_PYTHON=${STAGINGDIR_NATIVE}/python PYTHON_CFLAGS=-I${STAGING_INCDIR}/${PYTHON_DIR}"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/default
    install -d ${D}${sysconfdir}/distcc
    install -m 0755 ${WORKDIR}/distcc ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/default ${D}${sysconfdir}/default/distcc
    install -m 0644 ${WORKDIR}/distccmon-gnome.desktop ${D}${datadir}/distcc/
    echo "+zeroconf" > ${D}${sysconfdir}/distcc/hosts
}

PACKAGES += "distcc-distmon-gnome"

FILES_${PN} = " ${sysconfdir} \
		${bindir}/distcc \
		${bindir}/lsdistcc \
		${bindir}/distccd \
		${bindir}/distccmon-text"

FILES_${PN}-dbg += "${bindir}/.debug"

CONFFILES_${PN} += "${sysconfdir}/default/distcc \
                    ${sysconfdir}/distcc/hosts \
                    ${sysconfdir}/init.d/distcc \
                   " 

FILES_distcc-distmon-gnome = "  ${bindir}/distccmon-gnome \
				${datadir}/distcc"


pkg_postinst_${PN} () {
    # can't do this offline
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    grep "^distcc:" /etc/group > /dev/null || addgroup distcc
    grep "^distcc:" /etc/passwd > /dev/null || adduser --disabled-password --system --home /var/lib/distcc distcc --ingroup distcc -g "distcc daemon"
}

pkg_postrm_${PN} () {
    deluser distcc || true
    delgroup distcc || true
}
