SECTION = "console/network"
DESCRIPTION = "This package includes some useful diagnostics tools for \
IPv6 networks, including ndisc6, rdisc6, tcptraceroute6 and traceroute6."
SECTION = "console/network"
HOMEPAGE = "http://www.simphalempin.com/dev/ndisc6/"
LICENSE = "GPL"
PR = "r0"

# The tcptraceroute6 and tracert6 commands depend on rltraceroute6 to
# perform the actual trace operation.
RDEPENDS_${PN}-tcptraceroute6 = "${PN}-rltraceroute6"
RDEPENDS_${PN}-tracert6 = "${PN}-rltraceroute6"

SRC_URI = "http://www.remlab.net/files/ndisc6/ndisc6-${PV}.tar.bz2 \
	   file://autoconf-older-version.patch;patch=1 \
	   file://acinclude.m4"

inherit autotools

# Split into seperate packages since we normal don't want them all
# The main package is left empty and therefore not created.
PACKAGES += "${PN}-ndisc6 ${PN}-tcpspray6 ${PN}-rdisc6 \
	     ${PN}-tcptraceroute6 ${PN}-rltraceroute6 ${PN}-tracert6"
FILES_${PN}			= ""
FILES_${PN}-ndisc6		= "${bindir}/ndisc6"
FILES_${PN}-tcpspray6 		= "${bindir}/tcpspray6"
FILES_${PN}-rdisc6		= "${bindir}/rdisc6"
FILES_${PN}-tcptraceroute6	= "${bindir}/tcptraceroute6"
FILES_${PN}-rltraceroute6	= "${bindir}/rltraceroute6"
FILES_${PN}-tracert6		= "${bindir}/tracert6"

DESCRIPTION_${PN}-ndisc6	= "ICMPv6 Neighbor Discovery tool. \
Performs IPv6 neighbor discovery in userland. Replaces arping from the \
IPv4 world."
DESCRIPTION_${PN}-rdisc6	= "ICMPv6 Router Discovery tool. \
Queries IPv6 routers on the network for advertised prefixes. Can be used \
to detect rogue IPv6 routers, monitor legitimate IPv6 routers."
DESCRITPION_${PN}-tcpspray6	= "Performs bandwidth measurements of TCP \
sessions between the local system and a remote echo server in either IPv6 \
or IPv4."



# Add some macros from the autoconf 2.60 which to let us build with
# autoconf 2.59. This can be removed when/if we update to autoconf
# 2.60
do_configure_prepend() {
    cp ${WORKDIR}/acinclude.m4 ${S}
}


# Enable SUID bit for applications that need it
pkg_postinst_${PN}-rltraceroute6 () {
	chmod 4555 ${bindir}/rltraceroute6
}
pkg_postinst_${PN}-ndisc6 () {
	chmod 4555 ${bindir}/ndisc6
}
pkg_postinst_${PN}-rdisc6 () {
	chmod 4555 ${bindir}/rdisc6
}
