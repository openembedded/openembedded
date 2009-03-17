DESCRIPTION = "System Configuration save/restore functionality"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "devio cpio findutils diffutils"
PR = "r10"

# Currently, the scripts only support ixp4xx machines.
# Feel free to add to the scripts ...
COMPATIBLE_MACHINE = '(ixp4xx|nslu2)'

SRC_URI = "file://sysconfsetup \
	   file://conffiles \
	   file://sysconf \
	   "

SCRIPTS = "sysconf"
INITSCRIPTS = "sysconfsetup"

# This just makes things easier...
S="${WORKDIR}"

do_install() {
	# Directories
        install -d ${D}${sysconfdir} \
                   ${D}${sysconfdir}/default \
                   ${D}${sysconfdir}/init.d \
		   ${D}${base_sbindir}

	# Init scripts
	install -m 0755 sysconfsetup ${D}${sysconfdir}/init.d/

	# Configuration files
	install -m 0644 conffiles ${D}${sysconfdir}/default

	# Shell scripts
	install -m 0755 sysconf ${D}${base_sbindir}/sysconf
}

pkg_postinst() {
	opt=
	test -n "$D" && opt="-r $D"
	update-rc.d $opt sysconfsetup start 12 S .
}

pkg_postrm() {
	opt=
	test -n "$D" && opt="-r $D"
	update-rc.d $opt sysconfsetup remove
}
