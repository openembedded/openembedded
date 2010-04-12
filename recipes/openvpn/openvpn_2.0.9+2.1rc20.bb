require openvpn.inc

SRC_URI = "http://openvpn.net/release/openvpn-2.1_rc20.tar.gz \
	   file://openvpn"

S = "${WORKDIR}/openvpn-2.1_rc20"

# I want openvpn to be able to read password from file (hrw)
EXTRA_OECONF += "--enable-password-save"

SRC_URI[md5sum] = "8187f8f21507faac5e320e32747203b8"
SRC_URI[sha256sum] = "4d423b48cb3ccc66b5669b9404dcb028cb62af410361c09e6056db0c5d2a1267"
