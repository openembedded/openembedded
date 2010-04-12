require gnuradio-libusb-compat.inc

PR = "${INC_PR}.1"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-${PV}.tar.gz;name=archive \
	   file://acinclude.m4 \
      ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz;name=libusb \
"


SRC_URI[archive.md5sum] = "c1eb3de26b67ddc08a61a7c2fc636203"
SRC_URI[archive.sha256sum] = "36480bce862b6d424f4b34bbfeed838b80bcbb484602dee43c412a7d0dc4b42b"
SRC_URI[libusb.md5sum] = "caf182cbc7565dac0fd72155919672e6"
SRC_URI[libusb.sha256sum] = "37f6f7d9de74196eb5fc0bbe0aea9b5c939de7f500acba3af6fd643f3b538b44"
