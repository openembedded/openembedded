require clamav.inc

EXTRA_OECONF += "--program-transform-name=''"

PR = "${INC_PR}.1"

do_install_append() {
	# Remove deprecated options
	sed -ri "/Archive(Block)?Max/d" ${D}/${sysconfdir}/clamd.conf
}