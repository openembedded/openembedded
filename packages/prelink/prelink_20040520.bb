SECTION = "devel"
DEPENDS = "elfutils "
DESCRIPTION = " The prelink package contains a utility which modifies ELF shared libraries \
and executables, so that far fewer relocations need to be resolved at \
runtime and thus programs come up faster."
LICENSE = "GPL"
SRC_URI = "ftp://people.redhat.com/jakub/prelink/prelink-${PV}.tar.bz2"
S = "${WORKDIR}/prelink"

EXTRA_OECONF = "--disable-64bit"

inherit autotools 

do_install_append () {
	install -d ${D}${sysconfdir}/cron.daily ${D}${sysconfdir}/default
}
