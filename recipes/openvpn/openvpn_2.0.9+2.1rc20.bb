require openvpn.inc

SRC_URI = "http://openvpn.net/release/openvpn-2.1_rc20.tar.gz \
	   file://openvpn"

S = "${WORKDIR}/openvpn-2.1_rc20"

# I want openvpn to be able to read password from file (hrw)
EXTRA_OECONF += "--enable-password-save"
