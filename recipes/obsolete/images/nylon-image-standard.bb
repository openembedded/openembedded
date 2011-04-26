require nylon-image-base.bb

export IMAGE_BASENAME = "nylon-standard"

NYLON_STANDARD = "\
	dash \
	dnsmasq \
	hostap-daemon hostap-utils \
	linux-hotplug \
	ifplugd \
	iproute2 \
	madwifi-modules \
	nylon-config \
	olsrd \
	ppp \
	rp-pppoe \
	simple-firewall \
	tcpdump \
	wpa-supplicant \
	yamonenv"

DEPENDS += "hostap-modules ntp \
	${NYLON_STANDARD}"

IMAGE_INSTALL += "hostap-modules-pci ntpdate less nano elvis-tiny \
	${NYLON_STANDARD}"
