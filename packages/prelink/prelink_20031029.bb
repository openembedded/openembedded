SECTION = "devel"
DEPENDS = "elfutils "
DESCRIPTION = " The prelink package contains a utility which modifies ELF shared libraries \
and executables, so that far fewer relocations need to be resolved at \
runtime and thus programs come up faster."
LICENSE = "GPL"
SRC_URI = "ftp://people.redhat.com/jakub/prelink/prelink-${PV}.tar.bz2 \
           file://dso.c.patch;patch=1 \
           file://layout.c.patch;patch=1 \
           file://Makefile.in.patch;patch=1 \
           file://prelink.h.patch;patch=1 \
           file://ts.Makefile.am.patch;patch=1 \
           file://ts.Makefile.in.patch;patch=1 \
           file://prelink.conf \
           file://prelink.cron.daily \
           file://prelink.default"
S = "${WORKDIR}/prelink"

inherit autotools 

do_install_append () {
	install -d ${D}${sysconfdir}/cron.daily ${D}${sysconfdir}/default
	install -m 0644 ${WORKDIR}/prelink.conf ${D}${sysconfdir}/prelink.conf
	install -m 0644 ${WORKDIR}/prelink.cron.daily ${D}${sysconfdir}/cron.daily/prelink
	install -m 0644 ${WORKDIR}/prelink.default ${D}${sysconfdir}/default/prelink
}
