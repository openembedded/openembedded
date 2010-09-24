require openvpn.inc

PR = "${INC_PR}.0"
SRC_URI = "http://openvpn.net/release/${P}.tar.gz \
	   file://openvpn"

# I want openvpn to be able to read password from file (hrw)
EXTRA_OECONF += "--enable-password-save"
DEFAULT_PREFERENCE = "-1"

SRC_URI[md5sum] = "7486d3e270ba4b033e311d3e022a0ad7"
SRC_URI[sha256sum] = "5185181df2e6043bd667377bc92e36ea5a5bd7600af209654f109b6403ca5b36"
