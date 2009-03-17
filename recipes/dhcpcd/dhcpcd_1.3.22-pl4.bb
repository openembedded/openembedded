SECTION = "console/network"
LICENSE = "GPL"
DESCRIPTION = "dhcpcd is an RFC2131-, RFC2132-, and \
RFC1541-compliant DHCP client daemon. It gets an IP address \
and other information from the DHCP server, automatically \
configures the network interface, and tries to renew the \
lease time according to RFC2131 or RFC1541."
PR = "r1"

sbindir = "/sbin"

SRC_URI = "http://www.phystech.com/ftp/dhcpcd-${PV}.tar.gz \
	   file://config_dir.patch;patch=1 \
	   file://paths.patch;patch=1"

inherit autotools

