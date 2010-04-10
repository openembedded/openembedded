require bluez-utils3.inc


DEPENDS += "alsa-lib"

# see bluez-utils3.inc for the explanation of these option
EXTRA_OECONF = " \
                 --enable-bccmd \
		 --disable-hid2hci \
                 --enable-alsa \ 
		 --disable-cups \
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

FILES_${PN} = "${libdir}/alsa-lib/libasound*"

SRC_URI[md5sum] = "4fc292b635ba7b442c7aaf5680199012"
SRC_URI[sha256sum] = "d5781c9b6604c63720020169df4081c364f3f8e79df951db0421e89667fb891d"
