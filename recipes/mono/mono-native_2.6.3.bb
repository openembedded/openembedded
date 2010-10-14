require mono.inc
DEPENDS = "glib-2.0-native perl-native"

PR = "${INC_PR}.0"

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

SRC_URI[md5sum] = "b1dc21bac2c7c75814a9f32246eadadd"
SRC_URI[sha256sum] = "0ecb82d2007f472f8eebc85c349813515bf642e6ea021890ece40555ad50d947"

