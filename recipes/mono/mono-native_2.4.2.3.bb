require mono_2.4.2.3.inc
DEPENDS = "glib-2.0-native perl-native"

PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

SRC_URI += ""

inherit native

do_fix_libtool_name() {
	# inherit native will make that all native tools that are being
	# built are prefixed with something like "i686-linux-",
	# including libtool. Fix up some hardcoded libtool names:
	for i in "${S}"/runtime/*-wrapper.in; do
		sed -e "s/libtool/${BUILD_SYS}-libtool/" -i "${i}"
	done
}
addtask fix_libtool_name after do_patch before do_configure
