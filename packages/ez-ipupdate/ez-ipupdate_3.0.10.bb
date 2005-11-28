# Angus Mackay's ez-ipupdate from www.ez-ipupdate.com
DESCRIPTION = "A client for automatically updating your EZ-IP.net, justlinux.com, dhs.org, dyndns.org, ods.org, gnudip.cheapnet.net, tzo.com, easydns.com dynamic hostname parameters. Includes daemon support that only sends updates if your IP address changes."
HOMEPAGE = "http://www.ez-ipupdate.com/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.ez-ipupdate.com/dist/ez-ipupdate-${PV}.tar.gz"
SRC_URI += "file://configure.patch;patch=1"
SRC_URI += "file://conffile.patch;patch=1"
SRC_URI += "file://zoneedit.patch;patch=1"
SRC_URI += "file://init"
SRC_URI += "file://ipupdate.conf"

INITSCRIPT_NAME = "ipupdate"
# No dependencies, so just go in at the standard level (20)
INITSCRIPT_PARAMS = "defaults"

# The configuration file must be editted...
CONFFILES_${PN} = "${sysconfdir}/ipupdate.conf"

inherit autotools update-rc.d

PACKAGES = "ez-ipupdate"

do_install_append() {
	install -d "${D}${sysconfdir}/init.d"
	install -c -m 755 ${WORKDIR}/init "${D}${sysconfdir}/init.d/ipupdate"
	install -c -m 644 ${WORKDIR}/ipupdate.conf "${D}${sysconfdir}/ipupdate.conf"
}
