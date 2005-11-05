SECTION = "devel"
DEPENDS = "elfutils "
DESCRIPTION = " The prelink package contains a utility which modifies ELF shared libraries \
and executables, so that far fewer relocations need to be resolved at \
runtime and thus programs come up faster."
LICENSE = "PRELINK"
SRC_URI = "${DEBIAN_MIRROR}/main/p/prelink/prelink_0.0.${PV}.orig.tar.gz \
           file://prelink.conf \
           file://prelink.cron.daily \
           file://prelink.default"
S = "${WORKDIR}/prelink-0.0.${PV}"

inherit autotools 

do_install_append () {
	install -d ${D}${sysconfdir}/cron.daily ${D}${sysconfdir}/default
	install -m 0644 ${WORKDIR}/prelink.conf ${D}${sysconfdir}/prelink.conf
	install -m 0644 ${WORKDIR}/prelink.cron.daily ${D}${sysconfdir}/cron.daily/prelink
	install -m 0644 ${WORKDIR}/prelink.default ${D}${sysconfdir}/default/prelink
}
