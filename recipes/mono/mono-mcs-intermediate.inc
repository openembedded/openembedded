# This is a straw-man recipe for step 1 in the two-step build of
# mono. Because it's impossible to build the mcs directory
# in cross-compile mode, this recipe will do a native build,
# then tar the resulting install tree for usage by the mono
# package in step 2.
# See http://www.mono-project.com/Mono:ARM

PR = "r0"
DEPENDS = "mono-native glib-2.0-native perl-native"

SRC_URI += "file://mono-fix-libdir-path.patch"

# Inherit native to set up compiler and paths ...
inherit native
# ... but override the target prefix
exec_prefix = "/usr"
sysconfdir = "/etc"
# TODO: Where does the mono package get
# these paths from? Use the same source.

do_fix_libtool_name() {
	# inherit native will make that all native tools that are being
	# built are prefixed with something like "i686-linux-",
	# including libtool. Fix up some hardcoded libtool names:
	for i in "${S}"/runtime/*-wrapper.in; do
		sed -e "s/libtool/${BUILD_SYS}-libtool/" -i "${i}"
	done
}
addtask fix_libtool_name after do_patch before do_configure

do_compile_append() {
	oe_runmake 'DESTDIR=${D}' install
	cd ${D}
	rm -f ${WORKDIR}/mono-mcs-${PV}.tar.gz
	tar -cvzf ${WORKDIR}/mono-mcs-${PV}.tar.gz .
	install -d ${STAGING_DATADIR}/mono-mcs
	cp ${WORKDIR}/mono-mcs-${PV}.tar.gz ${STAGING_DATADIR}/mono-mcs/
}

do_package() {
	true
}

do_package_write_ipk() {
	true
}

do_package_write() {
	true
}
