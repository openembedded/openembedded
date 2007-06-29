#Angstrom gateway image
#gives you a gateway with SMB, ssh and dnsmasqs
LICENSE = "MIT"
PR = "r0"

ANGSTROM_EXTRA_INSTALL ?= ""
DISTRO_SSH_DAEMON ?= "dropbear"

RDEPENDS = "task-boot \
            ${DISTRO_SSH_DAEMON} \
            iptables \
            samba swat \
            dnsmasq \
#            vsftpd \
            angstrom-version \
	   "

export IMAGE_BASENAME = "gateway-image"
export IMAGE_LINGUAS = ""
export PACKAGE_INSTALL = "${RDEPENDS}"

inherit image

