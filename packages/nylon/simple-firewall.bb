DESCRIPTION = "simple firewall configuratiopn script"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
SRCDATE = "20060810"
PV = "cvs${SRCDATE}"


INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "http://meshcube.org/nylon/unstable/sources/${PN}_gruen.4g__${SRCDATE}.tar.gz"
S = "${WORKDIR}/${PN}"

do_install() {
	install -d -m 755 ${D}
	(cd ${S}; tar -c --exclude .svn -f - . ) | tar -C ${D} -xpf -
}
