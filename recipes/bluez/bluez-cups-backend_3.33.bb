require bluez-utils3.inc

PR = "r1"

DEPENDS += "cups"

# TI patch landed upstream sometime between 3.35 and 3.36, 
# albeit in a somewhat different form
SRC_URI += "file://hciattach-ti-bts.patch;patch=1"

# see bluez-utils3.inc for the explanation of these option
EXTRA_OECONF = " \
                 --enable-bccmd \
		 --enable-hid2hci \
                 --disable-alsa \ 
		 --enable-cups \
		 --enable-glib \
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


FILES_${PN} = "${libdir}/cups/backend/bluetooth"
RDEPENDS_${PN} = "cups"
