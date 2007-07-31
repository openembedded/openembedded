DESCRIPTION = "simple firewall configuratiopn script"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
#SRCDATE = "20060114"
SRCDATE = "20070130"
#SRCDATE = "${TOMORROW}"
PV = "cvs${SRCDATE}"

SRC_URI = "svn://gruen.4g/svn/trunk/application;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

do_install() {
	(cd ${S}; tar -c --exclude .svn -f - . ) | tar -C ${D} -xpf -
}
