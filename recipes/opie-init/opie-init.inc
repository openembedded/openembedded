DESCRIPTION = "Opie Startup scripts and config"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
#APPNAME = "qpe"

#S = "${WORKDIR}/launcher"

#inherit opie
inherit update-rc.d

INITSCRIPT_NAME = "opie"
INITSCRIPT_PARAMS = "start 99 5 . stop 20 0 1 6 ."

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/profile.d	
	install -d ${D}${bindir}
	install -d ${D}${palmtopdir}/etc/skel

	sed -s "s|@palmtopdir@|${palmtopdir}|" ${WORKDIR}/opie >${WORKDIR}/opie.tmp
	sed -s "s|@palmtopdir@|${palmtopdir}|" ${WORKDIR}/opie_defaults >${WORKDIR}/opie_defaults.tmp
	install -m 0755 ${WORKDIR}/opie.tmp ${D}${sysconfdir}/init.d/opie
	install -m 0644 ${WORKDIR}/opie_defaults.tmp ${D}${sysconfdir}/profile.d/opie_defaults

	install -m 0755 ${WORKDIR}/opie-reorgfiles ${D}${bindir}/
	install -m 0644 ${WORKDIR}/qpe.conf ${D}${palmtopdir}/etc/skel/

	if [ -s ${WORKDIR}/locale.conf ]; then
	    install -m 0644 ${WORKDIR}/locale.conf ${D}${palmtopdir}/etc/skel/
	fi

	case ${MACHINE} in
	c7x0)
		install -d ${D}${sysconfdir}/apm/event.d/
		install -m 0755 ${WORKDIR}/qpe-suspend-resume ${D}${sysconfdir}/apm/event.d/00-qpe-suspend-resume.sh
                ;;
        *)
                ;;
        esac	
}

#FILES_opie-init_append = " ${sysconfdir} ${palmtopdir}/bin"
FILES_${PN} += "${palmtopdir}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
