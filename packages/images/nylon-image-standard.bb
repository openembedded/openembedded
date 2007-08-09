require nylon-image-base.bb

export IMAGE_BASENAME = "nylon-standard"

NYLON_STANDARD = "\
	hostap-utils \
	linux-hotplug \
	ifplugd \
	olsrd \
	ppp \
	rp-pppoe \
	shorewall \
	tcpdump \
	wpa-supplicant"

DEPENDS += "hostap-modules ntp \
	${NYLON_STANDARD}"

RDEPENDS += "hostap-modules-pci ntpdate less nano elvis-tiny \
	${NYLON_STANDARD}"
