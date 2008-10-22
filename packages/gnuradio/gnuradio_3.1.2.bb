require gnuradio.inc

PR = "r5"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-${PV}.tar.gz \
	   file://no-trellis-doc.patch;patch=1 \
       file://gcc43.patch;patch=1;pnum=2 \
           file://gnuradio-libusb.patch;patch=1 \
	   "

