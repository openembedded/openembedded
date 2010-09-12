require ${PN}.inc
PV = "${OPIE_GIT_PV}"
PR = "r21"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/apps/calibrate \
           ${OPIE_GIT};protocol=git;subpath=noncore/settings/mediummount \
           ${OPIE_GIT};protocol=git;subpath=core/launcher \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps \
           ${OPIE_GIT};protocol=git;subpath=root \
           ${OPIE_GIT};protocol=git;subpath=etc \
           file://nomax.patch;striplevel=3 \
           file://no-builtin-qss-startup-2.patch \
           file://kbdlocks-runtime.patch \
           file://restart-from-bindir.patch \
           file://server-pro-cvs.patch \
           file://firstuse-path.patch \
           file://force-firstuse-calibrate.patch \
           file://03opiesignal \
          "

do_install_append() {
	install -d ${D}${bindir} ${D}${sysconfdir}/apm/event.d/
	install -m 0755 ${WORKDIR}/03opiesignal ${D}${sysconfdir}/apm/event.d/
	install -m 0644 ${WORKDIR}/etc/opie_sysevents.conf ${D}${sysconfdir}/
}

