require dhcp3.inc

SRC_URI = "ftp://ftp.isc.org/isc/dhcp/dhcp-3.1-history/dhcp-${PV}.tar.gz \
	   file://fixincludes.patch;patch=1 \
	   file://useless-use-of-bash.patch;patch=1 \
	   file://dhclient-script-exit-status.dpatch;patch=1 \
	   file://dhcp-3.0.3-dhclient-dbus.patch;patch=1;pnum=0 \
	   file://init-relay file://default-relay \
	   file://init-server file://default-server \
	   file://dhclient.conf file://dhcpd.conf"

PR = "${INC_PR}.0"
