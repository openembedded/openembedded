require mono_1.2.5.inc
PR = "r2"
DEPENDS = "glib-2.0-native perl-native"

SRC_URI += "file://mono-fix-libdir-path.patch;patch=1"

PARALLEL_MAKE = ""

inherit native

do_stage_prepend() {
	install -m 755 ${S}/mono/monoburg/monoburg ${STAGING_BINDIR}
}

do_fix_libtool_name() {
	# inherit native will make that all native tools that are being
	# built are prefixed with something like "i686-linux-",
	# including libtool. Fix up some hardcoded libtool names:
	for i in "${S}"/runtime/*-wrapper.in; do
		sed -e "s/libtool/${BUILD_SYS}-libtool/" -i "${i}"
	done
}
addtask fix_libtool_name after do_patch before do_configure

SRC_URI[md5sum] = "dfede0c8c29384a8f8a6953a9bd06224"
SRC_URI[sha256sum] = "434f91032e48c03e1202ba3cef1648e2708eeefcf51143d3547e34acc9c68a96"
