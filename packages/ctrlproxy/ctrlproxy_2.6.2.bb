DESCRIPTION = "ctrlproxy is an IRC server with multiserver support."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
DEPENDS = "glib-2.0 libxml2 popt pcre openssl"
PR = "r0"
LICENSE = "GPL"

SRC_URI = "http://sources.nslu2-linux.org/sources/ctrlproxy-2.6.2.tar.gz"
S = "${WORKDIR}/ctrlproxy-2.6.2/"

inherit autotools
# update-rc.d

#INITSCRIPT_NAME = "ctrlproxy"
#INITSCRIPT_PARAMS = "defaults 84"
# CONFFILES_${PN} = "${sysconfdir}/foo.conf" 

CFLAGS += "-L${STAGING_LIBDIR}"

#do_install() {
#	autotools_do_install
#	install -d ${D}${sysconfdir}
#	install -d ${D}${sysconfdir}/init.d
#	install -m 0644 ${S}contrib/foo.conf ${D}${sysconfdir}
#	install -m 0755 ${WORKDIR}/foo.init ${D}${sysconfdir}/init.d/foo
#}

