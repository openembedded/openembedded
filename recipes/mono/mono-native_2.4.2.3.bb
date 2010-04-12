require mono-${PV}.inc
DEPENDS = "glib-2.0-native perl-native"

PR = "${INC_PR}.1"

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

SRC_URI[md5sum] = "696f25afc8453cd0d1c78de6e905dcf2"
SRC_URI[sha256sum] = "1bab0d4e2906c88736ff5e242f2905f4c3535ccfc05bb5c427b72adf0e9236ae"
