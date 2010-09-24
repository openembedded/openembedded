require openvpn.inc

PR = "${INC_PR}.0"
SRC_URI = "http://openvpn.net/release/${P}.tar.gz \
	   file://openvpn"

# I want openvpn to be able to read password from file (hrw)
EXTRA_OECONF += "--enable-password-save"

SRC_URI[md5sum] = "452a83326ae198cf961e9ae02539c8fb"
SRC_URI[sha256sum] = "6634f89575040b1987a1e793b5d6fedb11088007eb150dbdab4a8cfdf3c0686e"
