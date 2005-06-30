include whois.inc

SRC_URI = "${DEBIAN_MIRROR}/main/w/whois/whois_${PV}.tar.gz"
S = "${WORKDIR}/whois-${PV}"

inherit gettext
