require gnuradio.inc

PR = "r4"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-${PV}.tar.gz \
	   file://acinclude.m4 \
      ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"
# This is an awful hack to allow GNU Radio to use libusb-0.12, regardless
# of what is used by the rest of OE

addtask buildlibusb before do_configure after do_unpack

