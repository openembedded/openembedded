#Angstrom gateway image
#gives you a gateway with SMB, ssh and dnsmasqs

SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-angstrom", "",d)}'

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_INSTALL = "task-boot \
            ${DISTRO_SSH_DAEMON} \
            iptables \
            samba swat \
            dnsmasq \
#            vsftpd \
            angstrom-version \
            ${SPLASH} \
	   "

export IMAGE_BASENAME = "gateway-image"
IMAGE_LINGUAS = ""

inherit image

