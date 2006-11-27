SECTION = "base"
DESCRIPTION = "A daemon for delivering ACPI events."
LICENSE="GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/acpid/acpid-${PV}.tar.gz \
   	   file://gcc40.patch;patch=1 \
           file://init"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'CROSS=${HOST_PREFIX}'
}

do_install () {
	oe_runmake 'INSTPREFIX=${D}' install
	install -d ${D}${sysconfdir}/init.d
	cat ${WORKDIR}/init | sed -e's,/usr/sbin,${sbindir},g' > ${D}${sysconfdir}/init.d/acpid
	chmod 755 ${D}${sysconfdir}/init.d/acpid
}

pkg_postinst () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D acpid defaults
}

pkg_prerm () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D acpid remove
}
