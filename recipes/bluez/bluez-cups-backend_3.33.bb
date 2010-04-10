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

SRC_URI[md5sum] = "2e02aabd1a48998a48a22797f59ccf14"
SRC_URI[sha256sum] = "c9e8f3aa3a34a558293faa1cb2b2204061852d045aaa5311bb1481f89751ab1d"
