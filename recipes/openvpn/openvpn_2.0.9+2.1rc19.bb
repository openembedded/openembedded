require openvpn.inc

SRC_URI = "http://openvpn.net/release/openvpn-2.1_rc19.tar.gz \
	   file://openvpn"

S = "${WORKDIR}/openvpn-2.1_rc19"

SRC_URI[md5sum] = "ba2ee667a8b7606b125b7d32f47ca578"
SRC_URI[sha256sum] = "d7f52e2217ed1cf367ca93257b27c8acb29fcae4fcaa31b4a94146a3c7a7de33"
