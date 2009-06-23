require gnuradio.inc

PR = "${INC_PR}.1"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-${PV}.tar.gz \
	   file://acinclude.m4 \
      ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"

