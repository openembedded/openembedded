include nylon-image-base.bb

export IMAGE_BASENAME = "nylon-standard"
 
NYLON_STANDARD = "\
	bridge-utils \
	dnsmasq \
	hostap-utils \
	hostap-daemon \
	linux-hotplug \
	ifplugd iproute2 iptables \
	madwifi-modules \
	nylon-scripts \
	olsrd \
	ppp pciutils \
	rp-pppoe \
	shorewall \
	tcpdump \
	usbutils \
	wireless-tools \
	wpa-supplicant \
	yamonenv"

DEPENDS += "hostap-modules ntp \
	${NYLON_STANDARD}"
	
RDEPENDS += "hostap-modules-pci ntpdate \
	${NYLON_STANDARD}"
LICENSE = MIT
