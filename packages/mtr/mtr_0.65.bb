DESCRIPTION = "mtr combines the functionality of the 'traceroute' and 'ping' programs in a single network diagnostic tool."
HOMEPAGE = "http://www.bitwizard.nl/mtr/"
LICENSE = "GPLv2"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
SRC_URI = "ftp://ftp.bitwizard.nl/mtr/mtr-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--without-gtk"

do_configure() {
	oe_runconf
}