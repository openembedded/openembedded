SECTION = "base"
PRIORITY = "optional"
DEPENDS = ""
DESCRIPTION = "Event driven system init"
LICENSE = "GPL"

inherit autotools pkgconfig update-alternatives

# --enable-compat builds halt, reboot, shutdown tools
EXTRA_OECONF += "--enable-compat"

# libupstart can be used for upstart event generation from other programs.
# However it is not used by upstart itself, so package it seperately.
PACKAGES =+ "libupstart libupstart-dev"
FILES_libupstart += "${libdir}/libupstart.so.*"
FILES_libupstart-dev += "${libdir}/libupstart.* ${includedir}/upstart/"

# upstart-sysvcompat provides Sys V Init compatible tools: halt, reboot,
# shutdown, telinit. These might be needed by other scripts.
PACKAGES =+ "upstart-sysvcompat upstart-sysvcompat-doc"
FILES_upstart-sysvcompat += " \
    ${base_sbindir}/reboot.* ${base_sbindir}/halt.* ${base_sbindir}/poweroff.* \
    ${base_sbindir}/shutdown.* ${base_sbindir}/telinit ${base_sbindir}/runlevel \
    ${sysconfdir}/event.d/control-alt-delete \
    ${sysconfdir}/event.d/rc* \
    ${sysconfdir}/event.d/sulogin \
    ${sysconfdir}/init.d \
    ${sysconfdir}/default/rcS \
"
FILES_upstart-sysvcompat-doc += " \
    ${mandir}/*/reboot.* ${mandir}/*/halt.* ${mandir}/*/poweroff.* \
     ${mandir}/*/shutdown.* ${mandir}/*/telinit.* ${mandir}/*/runlevel.* \
"

ALTERNATIVE_NAME = "init"
ALTERNATIVE_LINK = "${base_sbindir}/init"
ALTERNATIVE_PATH = "${base_sbindir}/init.${PN}"
ALTERNATIVE_PRIORITY = "60"

EXTRA_OEMAKE += "'bindir=${base_bindir}' \
		 'sbindir=${base_sbindir}' \
		 'usrbindir=${bindir}' \
		 'usrsbindir=${sbindir}' \
		 'includedir=${includedir}' \
		 'mandir=${mandir}'"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/event.d

	install -m 0644	${WORKDIR}/init/rcS-default	${D}${sysconfdir}/default/rcS
	install -m 0755 ${WORKDIR}/init/rc		${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init/rcS		${D}${sysconfdir}/init.d
	install -m 0644 ${WORKDIR}/rc*			${D}${sysconfdir}/event.d
	install -m 0644 ${WORKDIR}/control-alt-delete	${D}${sysconfdir}/event.d
	install -m 0644 ${WORKDIR}/sulogin		${D}${sysconfdir}/event.d

	if [ ! -z "${SERIAL_CONSOLE}" ]; then
	     cat <<EOF >> ${D}${sysconfdir}/event.d/tty-serial
# tty-serial - getty
#
# This service maintains a getty on tty-serial from the point the system is
# started until it is shut down again.

start on runlevel 2
start on runlevel 3
start on runlevel 4
start on runlevel 5

stop on runlevel 0
stop on runlevel 1
stop on runlevel 6

respawn
exec ${base_sbindir}/getty ${SERIAL_CONSOLE}
EOF
	fi
	if [ "${USE_VT}" = "1" ]; then
	    for n in ${SYSVINIT_ENABLED_GETTYS}
	    do
	     cat <<EOF >> ${D}${sysconfdir}/event.d/tty$n
# tty$n - getty
#
# This service maintains a getty on tty$n from the point the system is
# started until it is shut down again.

start on runlevel 2
start on runlevel 3
start on runlevel 4
start on runlevel 5

stop on runlevel 0
stop on runlevel 1
stop on runlevel 6

respawn
exec ${base_sbindir}/getty 38400 tty$n
EOF
	    done
	fi

	mv ${D}${base_sbindir}/init	${D}${base_sbindir}/init.${PN}
        mv ${D}${base_sbindir}/halt ${D}${base_sbindir}/halt.${PN}
	mv ${D}${base_sbindir}/reboot ${D}${base_sbindir}/reboot.${PN}
        mv ${D}${base_sbindir}/shutdown ${D}${base_sbindir}/shutdown.${PN}
	mv ${D}${base_sbindir}/poweroff ${D}${base_sbindir}/poweroff.${PN}
}

pkg_postinst_${PN}-sysvcompat () {
#!/bin/sh
update-alternatives --install ${base_sbindir}/reboot reboot reboot.${PN} 200
update-alternatives --install ${base_sbindir}/halt halt halt.${PN} 200
update-alternatives --install ${base_sbindir}/poweroff poweroff poweroff.${PN} 200
update-alternatives --install ${base_sbindir}/shutdown shutdown shutdown.${PN} 200
}

pkg_prerm_${PN}-sysvcompat () {
#!/bin/sh
update-alternatives --remove reboot reboot.${PN}
update-alternatives --remove halt halt.${PN}
update-alternatives --remove poweroff reboot.${PN}
update-alternatives --remove shutdown shutdown.${PN}
}
