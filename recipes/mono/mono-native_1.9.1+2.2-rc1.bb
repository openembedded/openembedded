require mono_2.2.0.inc
PR = "r3"
DEPENDS = "glib-2.0-native perl-native"

DEFAULT_PREFERENCE = "-1"

#SRC_URI += "file://mono-fix-libdir-path.patch;patch=1 \
#	    file://libgc_cppflags.patch;patch=1 \
#           "

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

SRC_URI[md5sum] = "6dfc8364f6e761d558f134a707bae421"
SRC_URI[sha256sum] = "44fc0eddf56c0abe861190051fceec6e223122c5835967459c69fbf98ee52067"
