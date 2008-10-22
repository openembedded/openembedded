require bluez-utils3.inc

PR = "r1"

DEPENDS += "gstreamer gst-plugins-base "

# see bluez-utils3.inc for the explanation of these option
EXTRA_OECONF = " \
                 --enable-bccmd \
		 --enable-hid2hci \
                 --enable-alsa \ 
		 --disable-cups \
		 --enable-glib \
		 --enable-gstreamer \
		 --disable-sdpd \
	         --enable-network \
	         --enable-serial \
	         --enable-input \
	         --enable-audio \
	         --enable-echo \
                 --enable-configfile \
	         --enable-initscripts \
		 --enable-test \
		" 


FILES_${PN} = "${libdir}/gstreamer-0.10/libgstbluetooth.so"
