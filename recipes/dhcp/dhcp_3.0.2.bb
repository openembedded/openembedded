require dhcp3.inc

SRC_URI = "ftp://ftp.isc.org/isc/dhcp/dhcp-3.0-history/dhcp-${PV}.tar.gz \
	   file://noattrmode.patch \
	   file://fixincludes.patch \
	   file://useless-use-of-bash.patch \
	   file://dhclient-script-exit-status.dpatch;apply=yes \
	   file://dhcp-3.0.3-dhclient-dbus.patch;striplevel=0 \
	   file://init-relay file://default-relay \
	   file://init-server file://default-server \
	   file://dhclient.conf file://dhcpd.conf"

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "04800a111521e7442749b2ce883f962b"
SRC_URI[sha256sum] = "21a6e0476fb880e704e0c3cfe7b2bc6a97f6b2b0654db10b38bdd317f511a03a"
