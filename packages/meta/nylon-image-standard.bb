include nylon-image-base.bb

export IMAGE_BASENAME = "nylon-standard"
 
NYLON_STANDARD = "\
	bridge-utils \
	dnsmasq \
	hostap-utils \
	hotplug \
	ifplugd iproute2 iptables \
	mobilemesh \
	nylon-scripts \
	ppp pciutils \
	rp-pppoe \
	shorewall \
	tcpdump \
	usbutils \
	wireless-tools \
	unik-olsrd"

DEPENDS += "hostap-modules ntp \ 
	${NYLON_STANDARD}"
	
RDEPENDS += "hostap-modules-pci ntpdate \
	${NYLON_STANDARD}"
