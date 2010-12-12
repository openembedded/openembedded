require ${PN}.inc
PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_apps_calibrate.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_mediummount.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_core_launcher.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_root.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.5-split_etc.tar.bz2 \
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

