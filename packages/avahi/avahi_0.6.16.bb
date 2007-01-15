require avahi.inc

FILES_avahi-autoipd = "${sbindir}/avahi-autoipd \
                       ${sysconfdir}/avahi/avahi-autoipd.action"

do_stage() {
	autotools_stage_all
}
