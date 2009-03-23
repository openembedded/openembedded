SRC_URI="${KERNELORG_MIRROR}/pub/linux/kernel/people/lenb/acpi/utils/pmtools-${PV}.tar.bz2"

S="${WORKDIR}/pmtools"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/usr/bin
	install ${S}/acpidump/acpidump ${D}/usr/bin
}
