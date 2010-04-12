require clamav.inc

EXTRA_OECONF += "--program-transform-name=''"

PR = "${INC_PR}.1"

do_install_append() {
	# Remove deprecated options
	sed -ri "/Archive(Block)?Max/d" ${D}/${sysconfdir}/clamd.conf
}
SRC_URI[clamav-0.94.2.md5sum] = "1181e6d62341b84708f126cc353f7ebf"
SRC_URI[clamav-0.94.2.sha256sum] = "1aec7fecff375958d067aceeb9782d3ff0be7c13bed0eecf6240fb089f8d268c"
